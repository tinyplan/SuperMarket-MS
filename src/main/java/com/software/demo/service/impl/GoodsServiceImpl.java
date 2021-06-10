package com.software.demo.service.impl;

import com.software.demo.dao.GoodsBaseInfoMapper;
import com.software.demo.dao.GoodsMapper;
import com.software.demo.dao.ImportMapper;
import com.software.demo.dao.StockRecordMapper;
import com.software.demo.entity.ResultStatus;
import com.software.demo.entity.StockEffectType;
import com.software.demo.entity.dto.GoodsBaseInfoDTO;
import com.software.demo.entity.dto.ImportGoodsDTO;
import com.software.demo.entity.dto.ModifyGoodsDTO;
import com.software.demo.entity.dto.SellGoodsDTO;
import com.software.demo.entity.po.Goods;
import com.software.demo.entity.po.GoodsBaseInfo;
import com.software.demo.entity.po.Import;
import com.software.demo.entity.po.StockRecord;
import com.software.demo.entity.vo.GoodsVO;
import com.software.demo.exception.BusinessException;
import com.software.demo.service.GoodsService;
import com.software.demo.util.IdUtil;
import com.software.demo.util.ObjectTransformUtil;
import com.software.demo.util.TimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tinyplan
 * 2021/6/3
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource(name = "goodsBaseInfoMapper")
    private GoodsBaseInfoMapper goodsBaseInfoMapper;

    @Resource(name = "goodsMapper")
    private GoodsMapper goodsMapper;

    @Resource(name = "importMapper")
    private ImportMapper importMapper;

    @Resource(name = "stockRecordMapper")
    private StockRecordMapper stockRecordMapper;

    @Override
    @Transactional
    public boolean addGoodsBaseInfo(GoodsBaseInfoDTO dto) {
        GoodsBaseInfo newBaseInfo = ObjectTransformUtil.transform(dto, GoodsBaseInfo.class);
        newBaseInfo.setId(IdUtil.generateBaseId(newBaseInfo.getName()));
        // 检查是否有相同的商品
        if (goodsBaseInfoMapper.queryGoodsBaseInfo(newBaseInfo.getId()) != null) {
            throw new BusinessException(ResultStatus.RES_FAIL, "请勿添加重复商品");
        }
        return goodsBaseInfoMapper.insertGoodsBaseInfo(newBaseInfo) == 1;
    }

    /**
     * 更新商品信息, 包括库存
     */
    @Override
    @Transactional
    public boolean modifyGoodsInfo(ModifyGoodsDTO dto) {
        // 更新商品信息
        Goods goods = ObjectTransformUtil.transform(dto, Goods.class);
        return goodsMapper.updateGoods(goods) == 1;
    }

    @Override
    @Transactional
    public boolean importGoods(ImportGoodsDTO dto) {
        GoodsBaseInfo baseInfo = goodsBaseInfoMapper.queryGoodsBaseInfo(dto.getGoodsBaseId());
        if (baseInfo == null) {
            throw new BusinessException(ResultStatus.RES_FAIL, "没有这种商品");
        }
        String importId = IdUtil.generateImportId(importMapper.maxId());
        String goodsId = IdUtil.generateGoodsId(importId, baseInfo.getId());
        // 整理进货信息
        Import newImport = ObjectTransformUtil.transform(dto, Import.class);
        newImport.setImportId(importId);
        newImport.setGoodsId(goodsId);
        newImport.setImportDate(TimeUtil.nowDate(TimeUtil.FORMATTER_DATE));
        // 整理商品信息
        Goods goods = ObjectTransformUtil.transform(dto, Goods.class);
        goods.setId(goodsId);
        goods.setName(baseInfo.getName());
        goods.setType(baseInfo.getType());
        goods.setStock(dto.getImportGoodsSum());
        goods.setExpirationDate(TimeUtil.plusDay(goods.getProductionDate(), goods.getDuration(), TimeUtil.FORMATTER_DATE));
        // 整理库存修改记录
        StockRecord record = new StockRecord();
        record.setRecordId(IdUtil.generateRecordId(stockRecordMapper.maxId()));
        record.setImportId(importId);
        record.setGoodsId(goodsId);
        record.setEffectType(StockEffectType.ADD.getKey());
        record.setEffectNum(dto.getImportGoodsSum());
        record.setEffectTime(TimeUtil.nowTime());

        return importMapper.insertImport(newImport) == 1
                && goodsMapper.insertGoods(goods) == 1
                && stockRecordMapper.insertRecord(record) == 1;
    }

    @Transactional
    @Override
    public boolean sellGoods(SellGoodsDTO dto) {
        Goods goods = goodsMapper.queryGoodsById(dto.getGoodsId());
        // 检查商品是否存在
        if (goods == null) {
            throw new BusinessException(ResultStatus.RES_FAIL, "没有这种商品");
        }
        // 检查是否过期
        if (!TimeUtil.isBeforeDate(TimeUtil.nowDate(), goods.getExpirationDate())) {
            throw new BusinessException(ResultStatus.RES_FAIL, "商品已经过期, 无法出售, 请及时处理");
        }
        Goods newGoodsInfo = new Goods();
        newGoodsInfo.setId(dto.getGoodsId());
        // 减库存
        Integer stock = goods.getStock();
        Integer sellNum = dto.getGoodsNum();
        if (stock < sellNum) {
            throw new BusinessException(ResultStatus.RES_FAIL, "库存不足");
        }
        stock -= dto.getGoodsNum();
        newGoodsInfo.setStock(stock);
        // 记录库存修改
        StockRecord record = new StockRecord();
        record.setRecordId(IdUtil.generateRecordId(stockRecordMapper.maxId()));
        record.setGoodsId(dto.getGoodsId());
        record.setEffectType(StockEffectType.SUBTRACT.getKey());
        record.setEffectNum(sellNum);
        record.setEffectTime(TimeUtil.nowTime());

        return goodsMapper.updateGoods(newGoodsInfo) == 1
                && stockRecordMapper.insertRecord(record) == 1;
    }

    /**
     * 分页查询(物理分页)
     *
     * @param limit 每页数量
     * @return 查询得到的数据列表
     */
    @Override
    public List<GoodsVO> queryGoods(Integer limit) {
        // List<GoodsDO> goodsList = goodsMapper.queryGoods((page - 1) * limit, limit);
        List<Goods> goodsDOList = goodsMapper.queryAllGoods();
        List<GoodsVO> goodsVOList = new ArrayList<>(goodsDOList.size());
        goodsDOList.forEach(goods -> goodsVOList.add(ObjectTransformUtil.transform(goods, GoodsVO.class)));
        return goodsVOList;
    }

}

package com.software.demo.service.impl;

import com.software.demo.dao.*;
import com.software.demo.entity.ResultStatus;
import com.software.demo.entity.StockEffectType;
import com.software.demo.entity.domain.TotalCostDO;
import com.software.demo.entity.domain.TotalNumAndPriceDO;
import com.software.demo.entity.domain.TotalRefundDO;
import com.software.demo.entity.dto.*;
import com.software.demo.entity.po.Goods;
import com.software.demo.entity.po.GoodsBaseInfo;
import com.software.demo.entity.po.Import;
import com.software.demo.entity.po.StockRecord;
import com.software.demo.entity.vo.FinanceSummaryVO;
import com.software.demo.entity.vo.GoodsVO;
import com.software.demo.exception.BusinessException;
import com.software.demo.service.GoodsService;
import com.software.demo.util.IdUtil;
import com.software.demo.util.ObjectTransformUtil;
import com.software.demo.util.TimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Resource(name = "financeMapper")
    private FinanceMapper financeMapper;

    @Override
    @Transactional
    public boolean addGoodsBaseInfo(GoodsBaseInfoDTO dto) {
        GoodsBaseInfo newBaseInfo = ObjectTransformUtil.transform(dto, GoodsBaseInfo.class);
        newBaseInfo.setId(IdUtil.generateBaseId(newBaseInfo.getName()));
        // 检查是否有相同的商品
        if (goodsBaseInfoMapper.queryGoodsBaseInfo(newBaseInfo) != null) {
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
        GoodsBaseInfo queryBaseInfo = new GoodsBaseInfo(null, dto.getGoodsName(), dto.getGoodsType());
        GoodsBaseInfo baseInfo = goodsBaseInfoMapper.queryGoodsBaseInfo(queryBaseInfo);
        if (baseInfo == null) {
            throw new BusinessException(ResultStatus.RES_FAIL, "没有这种商品");
        }
        if (TimeUtil.isBeforeDate(TimeUtil.nowDate(), dto.getProductionDate())) {
            throw new BusinessException(ResultStatus.RES_FAIL, "生产日期不能晚于当天");
        }
        String expireDate = TimeUtil.plusDayForDate(dto.getProductionDate(), dto.getDuration(), TimeUtil.FORMATTER_DATE);
        if (TimeUtil.isBeforeDate(expireDate, TimeUtil.nowDate())) {
            throw new BusinessException(ResultStatus.RES_FAIL, "该商品已过期, 请确认信息填写无误");
        }
        String importId = IdUtil.generateImportId(importMapper.maxId());
        String goodsId = IdUtil.generateGoodsId(importId, baseInfo.getId());
        // 整理进货信息
        Import newImport = ObjectTransformUtil.transform(dto, Import.class);
        newImport.setGoodsBaseId(baseInfo.getId());
        newImport.setImportId(importId);
        newImport.setGoodsId(goodsId);
        newImport.setImportDate(TimeUtil.nowDate(TimeUtil.FORMATTER_DATE));
        // 整理商品信息
        Goods goods = ObjectTransformUtil.transform(dto, Goods.class);
        goods.setId(goodsId);
        goods.setName(baseInfo.getName());
        goods.setType(baseInfo.getType());
        goods.setStock(dto.getImportGoodsSum());
        goods.setExpirationDate(expireDate);
        // 整理库存修改记录
        StockRecord record = new StockRecord();
        record.setRecordId(IdUtil.generateRecordId(stockRecordMapper.maxId()));
        record.setImportId(importId);
        record.setGoodsId(goodsId);
        // 进货的时候不用添加售价, 利润信息
        record.setPrice(0.0f);
        record.setProfits(0.0f);
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
        record.setPrice(goods.getPrice());
        record.setProfits(goods.getPrice() - goods.getCost());
        record.setEffectType(StockEffectType.SUBTRACT.getKey());
        record.setEffectNum(sellNum);
        record.setEffectTime(TimeUtil.nowTime());

        return goodsMapper.updateGoods(newGoodsInfo) == 1
                && stockRecordMapper.insertRecord(record) == 1;
    }

    @Override
    @Transactional
    public boolean refundGoods(RefundGoodsDTO dto) {
        StockRecord stockRecord = goodsMapper.queryRecordByRecordId(dto.getRecordId());
        Goods goods = goodsMapper.queryGoodsById(dto.getGoodsId());
        // 检查商品是否存在
        if (goods == null) {
            throw new BusinessException(ResultStatus.RES_FAIL, "没有这种商品");
        }
        // 检查商品是否出售过
        if (stockRecord == null || stockRecord.getEffectType() != -1) {
            throw new BusinessException(ResultStatus.RES_FAIL, "没有出售过该商品");
        }
        // 检查是否超过了退款期限
        String now = TimeUtil.nowTime();
        String deadline = TimeUtil.plusDayForTime(stockRecord.getEffectTime(), 3, TimeUtil.FORMATTER_TIME);
        if (TimeUtil.isBeforeTime(deadline, now)) {
            throw new BusinessException(ResultStatus.RES_FAIL, "超过了退款期限");
        }
        // 检查是否超过了出售数量
        if (dto.getGoodsNum() > stockRecord.getEffectNum()) {
            throw new BusinessException(ResultStatus.RES_FAIL, "退款的数量超过了出售数量");
        }
        // 加库存
        Goods newGoodsInfo = new Goods();
        newGoodsInfo.setId(dto.getGoodsId());
        newGoodsInfo.setStock(goods.getStock() + dto.getGoodsNum());
        // 保存库存记录
        StockRecord record = new StockRecord();
        record.setRecordId(IdUtil.generateRecordId(stockRecordMapper.maxId()));
        record.setGoodsId(dto.getGoodsId());
        record.setPrice(goods.getPrice());
        record.setProfits(goods.getPrice() - goods.getCost());
        record.setEffectType(StockEffectType.ADD.getKey());
        record.setEffectNum(dto.getGoodsNum());
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
        for (Goods goods : goodsDOList) {
            goodsVOList.add(ObjectTransformUtil.transform(goods, GoodsVO.class));
        }
        return goodsVOList;
    }

    @Override
    public List<FinanceSummaryVO> queryFinanceSummary(String type) {
        // 保证操作开始的时间一致
        LocalDate now = LocalDate.now();
        // 总成本
        String start = now.format(TimeUtil.FORMATTER_DATE);
        String end = now.plusDays(1).format(TimeUtil.FORMATTER_DATE);
        if ("month".equals(type)) {
            start = TimeUtil.firstDateOfMonth(now);
            end = TimeUtil.firstDateOfNextMonth(now);
        }
        List<TotalCostDO> costDOList = financeMapper.queryAllGoodsCost(start, end);
        // 总销量, 总销售额
        start = TimeUtil.firstTimeOfDay(now);
        end = TimeUtil.firstTimeOfNextDay(now);
        if ("month".equals(type)) {
            start = TimeUtil.firstTimeOfMonth(now);
            end = TimeUtil.firstTimeOfNextMonth(now);
        }
        List<TotalNumAndPriceDO> numList = financeMapper.queryAllGoodsNumAndPrice(start, end);
        List<TotalRefundDO> refundDOList = financeMapper.queryAllGoodsRefund(start, end);
        List<FinanceSummaryVO> result = new ArrayList<>();
        FinanceSummaryVO temp = null;
        for (TotalCostDO costDO : costDOList) {
            temp = new FinanceSummaryVO();
            temp.setGoodsBaseId(costDO.getGoodsBaseId());
            temp.setGoodsName(costDO.getGoodsName());
            temp.setGoodsType(costDO.getGoodsType());
            temp.setTotalNum(0);
            temp.setTotalPrice(0.0F);
            temp.setTotalProfits(0.0F);
            for (TotalNumAndPriceDO numAndPriceDO : numList) {
                if (temp.getGoodsBaseId().equals(numAndPriceDO.getGoodsBaseId())) {
                    temp.setTotalNum(numAndPriceDO.getTotalNum());
                    temp.setTotalPrice(numAndPriceDO.getTotalPrice());
                    temp.setTotalProfits(numAndPriceDO.getTotalPrice() - costDO.getTotalCost());
                    break;
                }
            }
            float refund = 0.0f;
            for (TotalRefundDO refundDO : refundDOList) {
                if (temp.getGoodsBaseId().equals(refundDO.getGoodsBaseId())) {
                    refund = refundDO.getRefundProfits();
                    break;
                }
            }
            temp.setTotalProfits(temp.getTotalProfits() - refund);
            result.add(temp);
        }
        return result;
    }
}

package com.software.demo.service.impl;

import com.software.demo.dao.GoodsMapper;
import com.software.demo.entity.ResultStatus;
import com.software.demo.entity.domain.GoodsDO;
import com.software.demo.entity.po.Goods;
import com.software.demo.entity.vo.GoodsVO;
import com.software.demo.exception.BusinessException;
import com.software.demo.service.GoodsService;
import com.software.demo.util.ObjectTransformUtil;
import com.software.demo.util.TimeFormatUtil;
import org.springframework.stereotype.Service;

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

    @Resource(name = "goodsMapper")
    private GoodsMapper goodsMapper;

    @Override
    public boolean modifyGoodsInfo(Goods goods) {
        // 手动设置过期时间
        LocalDate expireDate = LocalDate.parse(goods.getProductionDate(), TimeFormatUtil.FORMATTER);
        goods.setExpirationDate(expireDate.plusDays(goods.getDuration()).format(TimeFormatUtil.FORMATTER));
        return goodsMapper.updateGoods(goods) == 1;
    }

    /**
     * 分页查询(物理分页)
     *
     * @param page  当前页
     * @param limit 每页数量
     * @return 查询得到的数据列表
     */
    @Override
    public List<GoodsVO> queryGoods(Integer page, Integer limit) {
        List<GoodsDO> goodsList = goodsMapper.queryGoods((page - 1) * limit, limit);
        List<GoodsVO> goodsVOList = new ArrayList<>(goodsList.size());
        goodsList.forEach(goods -> {
            try {
                goodsVOList.add(ObjectTransformUtil.transform(goods, GoodsVO.class));
            } catch (Exception e){
                throw new BusinessException(ResultStatus.RES_FAIL, e.getMessage());
            }
        });
        return goodsVOList;
    }

    @Override
    public List<Goods> queryAllGoods() {
        return goodsMapper.queryAllGoods();
    }
}

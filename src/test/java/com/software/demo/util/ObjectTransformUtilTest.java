package com.software.demo.util;

import com.software.demo.entity.po.Goods;
import com.software.demo.entity.po.Import;
import com.software.demo.entity.po.StockRecord;
import com.software.demo.entity.vo.GoodsVO;
import org.junit.jupiter.api.Test;

/**
 * @author tinyplan
 * 2021/6/5
 */
class ObjectTransformUtilTest {

    @Test
    void transform() {
        // Goods goods = new Goods(IdUtil.generateGoodsId("小熊饼干"),"小熊饼干","饼干",
        //         10f,105f,"2015-3-3",40,"2016-6-7");
        // GoodsVO goodsVO = ObjectTransformUtil.transform(goods, GoodsVO.class);
        // System.out.println(goodsVO);
    }

    @Test
    void getFieldForPreparedStatement() {
        System.out.println(ObjectTransformUtil.getFieldForPreparedStatement(StockRecord.class));
    }
}
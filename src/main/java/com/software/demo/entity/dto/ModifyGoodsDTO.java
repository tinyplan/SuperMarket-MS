package com.software.demo.entity.dto;

import com.software.demo.annotation.ParamMapping;
import com.software.demo.entity.po.Goods;

/**
 * @author tinyplan
 * 2021/6/3
 *
 * 修改商品信息表单
 */
public class ModifyGoodsDTO {
    @ParamMapping(targetClz = Goods.class, targetField = "id")
    private String goodsId;
    @ParamMapping(targetClz = Goods.class, targetField = "price")
    private Float goodsPrice;
    private Integer stock;

    public ModifyGoodsDTO() {
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}

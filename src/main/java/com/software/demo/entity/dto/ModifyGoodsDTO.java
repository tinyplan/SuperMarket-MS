package com.software.demo.entity.dto;

import com.software.demo.annotation.ParamMapping;
import com.software.demo.entity.po.Goods;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author tinyplan
 * 2021/6/3
 *
 * 修改商品信息表单
 */
public class ModifyGoodsDTO {
    @ParamMapping(targetClz = Goods.class, targetField = "id")
    @NotBlank(message = "商品编号不能为空")
    private String goodsId;
    @ParamMapping(targetClz = Goods.class, targetField = "price")
    @NotNull(message = "价格不能为空")
    private Float goodsPrice;
    @NotNull(message = "库存不能为空")
    @Min(value = 0, message = "库存不能为负数")
    @Max(value = 10000, message = "库存需小于10000")
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

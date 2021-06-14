package com.software.demo.entity.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author tinyplan
 * 2021/6/10
 */
public class SellGoodsDTO {
    @NotBlank(message = "商品编号不能为空")
    private String goodsId;
    @NotNull(message = "购买数量不能为空")
    @Min(value = 0, message = "购买数量不能为负数")
    @Max(value = 10000, message = "购买数量需小于10000")
    private Integer goodsNum;

    public SellGoodsDTO() {
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
}

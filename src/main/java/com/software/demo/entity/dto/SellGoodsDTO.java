package com.software.demo.entity.dto;

/**
 * @author tinyplan
 * 2021/6/10
 */
public class SellGoodsDTO {
    private String goodsId;
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

package com.software.demo.entity.domain;

/**
 * @author tinyplan
 * 2021/06/13
 */
public class TotalNumAndPriceDO {
    private String goodsBaseId;
    private Integer totalNum;
    private Float totalPrice;

    public TotalNumAndPriceDO() {
    }

    public String getGoodsBaseId() {
        return goodsBaseId;
    }

    public void setGoodsBaseId(String goodsBaseId) {
        this.goodsBaseId = goodsBaseId;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "TotalNumAndPriceDO{" +
                "goodsBaseId='" + goodsBaseId + '\'' +
                ", totalNum=" + totalNum +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

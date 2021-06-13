package com.software.demo.entity.vo;

/**
 * @author tinyplan
 * 2021/6/13
 */
public class FinanceSummaryVO {
    private String goodsBaseId;
    private String goodsName;
    private String goodsType;
    private Integer totalNum;
    private Float totalPrice;
    private Float totalProfits;

    public FinanceSummaryVO() {
    }

    public String getGoodsBaseId() {
        return goodsBaseId;
    }

    public void setGoodsBaseId(String goodsBaseId) {
        this.goodsBaseId = goodsBaseId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
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

    public Float getTotalProfits() {
        return totalProfits;
    }

    public void setTotalProfits(Float totalProfits) {
        this.totalProfits = totalProfits;
    }
}

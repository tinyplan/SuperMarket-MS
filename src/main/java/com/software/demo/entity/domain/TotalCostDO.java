package com.software.demo.entity.domain;

/**
 * @author tinyplan
 * 2021/06/13
 */
public class TotalCostDO {
    private String goodsBaseId;
    private String goodsName;
    private String goodsType;
    private Float totalCost;

    public TotalCostDO() {
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

    public Float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "TotalCostDO{" +
                "goodsBaseId='" + goodsBaseId + '\'' +
                ", totalCost=" + totalCost +
                '}';
    }
}

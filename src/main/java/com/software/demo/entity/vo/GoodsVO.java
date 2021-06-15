package com.software.demo.entity.vo;

/**
 * @author tinyplan
 * 2021/6/5
 */
public class GoodsVO {
    private String goodsId;
    private String goodsName;
    private String goodsType;
    private Float goodsCost;
    private Float goodsPrice;
    private String productionDate;
    // 保质期(天)
    private Integer duration;
    // 过期时间
    private String expirationDate;
    private Integer stock;

    public GoodsVO() {
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
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

    public Float getGoodsCost() {
        return goodsCost;
    }

    public void setGoodsCost(Float goodsCost) {
        this.goodsCost = goodsCost;
    }

    public Float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "GoodsVO{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsCost=" + goodsCost +
                ", goodsPrice=" + goodsPrice +
                ", productionDate='" + productionDate + '\'' +
                ", duration=" + duration +
                ", expirationDate='" + expirationDate + '\'' +
                ", stock=" + stock +
                '}';
    }
}

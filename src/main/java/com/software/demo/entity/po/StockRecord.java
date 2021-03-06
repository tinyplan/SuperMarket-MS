package com.software.demo.entity.po;

/**
 * @author tinyplan
 * 2021/6/9
 */
public class StockRecord {
    private String recordId;
    private String importId;
    private String goodsId;
    private Float price;
    private Float profits;
    private Integer effectType;
    private Integer effectNum;
    private String effectTime;

    public StockRecord() {
    }

    public StockRecord(String recordId, String importId, String goodsId, Float price, Float profits, Integer effectType, Integer effectNum, String effectTime) {
        this.recordId = recordId;
        this.importId = importId;
        this.goodsId = goodsId;
        this.price = price;
        this.profits = profits;
        this.effectType = effectType;
        this.effectNum = effectNum;
        this.effectTime = effectTime;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getProfits() {
        return profits;
    }

    public void setProfits(Float profits) {
        this.profits = profits;
    }

    public Integer getEffectType() {
        return effectType;
    }

    public void setEffectType(Integer effectType) {
        this.effectType = effectType;
    }

    public Integer getEffectNum() {
        return effectNum;
    }

    public void setEffectNum(Integer effectNum) {
        this.effectNum = effectNum;
    }

    public String getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(String effectTime) {
        this.effectTime = effectTime;
    }
}

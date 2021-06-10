package com.software.demo.entity.po;

/**
 * @author tinyplan
 * 2021/6/9
 */
public class StockRecord {
    private String recordId;
    private String importId;
    private String goodsId;
    private Integer effectType;
    private Integer effectNum;
    private String effectTime;

    public StockRecord() {
    }

    public StockRecord(String recordId, String importId, String goodsId, Integer effectType, Integer effectNum, String effectTime) {
        this.recordId = recordId;
        this.importId = importId;
        this.goodsId = goodsId;
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

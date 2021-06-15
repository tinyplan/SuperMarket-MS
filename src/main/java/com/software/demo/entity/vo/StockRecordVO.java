package com.software.demo.entity.vo;

/**
 * @author tinyplan
 * 2021/6/12
 *
 * 库存记录页面专用
 */
public class StockRecordVO {
    private String recordId;
    private String importId;
    private String goodsId;
    private String goodsName;
    private String effectType;
    private String effectNum;
    private String effectTime;

    public StockRecordVO() {
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getEffectType() {
        return effectType;
    }

    public void setEffectType(String effectType) {
        this.effectType = effectType;
    }

    public String getEffectNum() {
        return effectNum;
    }

    public void setEffectNum(String effectNum) {
        this.effectNum = effectNum;
    }

    public String getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(String effectTime) {
        this.effectTime = effectTime;
    }

    @Override
    public String toString() {
        return "StockRecordVO{" +
                "recordId='" + recordId + '\'' +
                ", importId='" + importId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", effectType='" + effectType + '\'' +
                ", effectNum='" + effectNum + '\'' +
                ", effectTime='" + effectTime + '\'' +
                '}';
    }
}

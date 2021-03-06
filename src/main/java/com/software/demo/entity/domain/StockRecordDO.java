package com.software.demo.entity.domain;

import com.software.demo.annotation.ParamMapping;
import com.software.demo.entity.vo.StockRecordVO;

/**
 * @author tinyplan
 * 2021/6/12
 */
public class StockRecordDO {
    private String recordId;
    private String importId;
    private String goodsId;
    private String goodsName;
    private Float price;
    private Float profits;
    @ParamMapping(targetClz = StockRecordVO.class, ignore = true)
    private Integer effectType;
    @ParamMapping(targetClz = StockRecordVO.class, ignore = true)
    private Integer effectNum;
    private String effectTime;

    public StockRecordDO() {
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

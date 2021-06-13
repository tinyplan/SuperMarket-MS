package com.software.demo.entity.domain;

import com.software.demo.annotation.ParamMapping;
import com.software.demo.entity.vo.SalesRecordVO;
import com.software.demo.entity.vo.StockRecordVO;

/**
 * @author yjn
 * 2021/06/13
 */
public class SalesRecordDO {
    private String recordId;
    @ParamMapping(targetClz = SalesRecordVO.class, ignore = true)
    private String importId;
    private String goodsId;
    private String goodsName;
    private String goodsType;
    @ParamMapping(targetClz = SalesRecordVO.class, targetField = "goodsPrice")
    private Float price;
    @ParamMapping(targetClz = SalesRecordVO.class, ignore = true)
    private Float profits;
    @ParamMapping(targetClz = SalesRecordVO.class, ignore = true)
    private Integer effectType;
    @ParamMapping(targetClz = SalesRecordVO.class, targetField = "goodsNum")
    private Integer effectNum;
    @ParamMapping(targetClz = SalesRecordVO.class, targetField = "time")
    private String effectTime;

    public SalesRecordDO() {
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

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
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

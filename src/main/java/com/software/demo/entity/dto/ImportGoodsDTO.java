package com.software.demo.entity.dto;

import com.software.demo.annotation.ParamMapping;
import com.software.demo.entity.po.Goods;
import com.software.demo.entity.po.Import;

/**
 * @author tinyplan
 * 2021/6/3
 * <p>
 * 进货信息表单
 */
public class ImportGoodsDTO {
    private String goodsName;
    private String goodsType;
    @ParamMapping(targetClz = Import.class, ignore = true)
    @ParamMapping(targetClz = Goods.class, targetField = "cost")
    private Float goodsCost;
    @ParamMapping(targetClz = Import.class, ignore = true)
    @ParamMapping(targetClz = Goods.class, targetField = "price")
    private Float goodsPrice;
    @ParamMapping(targetClz = Import.class, ignore = true)
    private String productionDate;
    @ParamMapping(targetClz = Import.class, ignore = true)
    private Integer duration;
    @ParamMapping(targetClz = Goods.class, ignore = true)
    private Integer importGoodsSum;

    public ImportGoodsDTO() {
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

    public Integer getImportGoodsSum() {
        return importGoodsSum;
    }

    public void setImportGoodsSum(Integer importGoodsSum) {
        this.importGoodsSum = importGoodsSum;
    }
}

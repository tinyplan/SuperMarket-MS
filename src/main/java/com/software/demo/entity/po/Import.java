package com.software.demo.entity.po;

public class Import {
    private String importId;
    private String goodsBaseId;
    private String goodsId;
    private Integer importGoodsSum;
    private String importDate;

    public Import(){
    }

    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId;
    }

    public String getGoodsBaseId() {
        return goodsBaseId;
    }

    public void setGoodsBaseId(String goodsBaseId) {
        this.goodsBaseId = goodsBaseId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getImportGoodsSum() {
        return importGoodsSum;
    }

    public void setImportGoodsSum(Integer importGoodsSum) {
        this.importGoodsSum = importGoodsSum;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }
}

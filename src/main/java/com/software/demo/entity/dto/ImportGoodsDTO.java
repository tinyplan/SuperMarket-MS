package com.software.demo.entity.dto;

/**
 * @author tinyplan
 * 2021/6/3
 *
 * 进货信息表单
 */
public class ImportGoodsDTO {
    private Integer goodsBaseId;
    private Integer importGoodsSum;

    public ImportGoodsDTO() {
    }

    public Integer getGoodsBaseId() {
        return goodsBaseId;
    }

    public void setGoodsBaseId(Integer goodsBaseId) {
        this.goodsBaseId = goodsBaseId;
    }

    public Integer getImportGoodsSum() {
        return importGoodsSum;
    }

    public void setImportGoodsSum(Integer importGoodsSum) {
        this.importGoodsSum = importGoodsSum;
    }
}

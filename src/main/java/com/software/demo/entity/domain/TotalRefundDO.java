package com.software.demo.entity.domain;

/**
 * @author tinyplan
 * 2021/06/13
 */
public class TotalRefundDO {
    private String goodsBaseId;
    private Float refundProfits;

    public TotalRefundDO() {
    }

    public String getGoodsBaseId() {
        return goodsBaseId;
    }

    public void setGoodsBaseId(String goodsBaseId) {
        this.goodsBaseId = goodsBaseId;
    }

    public Float getRefundProfits() {
        return refundProfits;
    }

    public void setRefundProfits(Float refundProfits) {
        this.refundProfits = refundProfits;
    }
}

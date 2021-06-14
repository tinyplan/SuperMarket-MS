package com.software.demo.entity.dto;

/**
 * @author yjn
 * 2021/06/14
 */
public class RefundGoodsDTO {
    private String recordId;
    private String goodsId;
    private Integer goodsNum;

    public RefundGoodsDTO() {
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
}

package com.software.demo.entity.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author yjn
 * 2021/06/14
 */
public class RefundGoodsDTO {
    @NotBlank(message = "记录编号不能为空")
    private String recordId;
    @NotBlank(message = "商品编号不能为空")
    private String goodsId;
    @Min(value = 0, message = "退款数量不能为负数")
    @Max(value = 10000, message = "退款数量需小于10000")
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

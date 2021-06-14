package com.software.demo.entity.dto;

import com.software.demo.annotation.ParamMapping;
import com.software.demo.entity.po.Goods;
import com.software.demo.entity.po.Import;

import javax.validation.constraints.*;

/**
 * @author tinyplan
 * 2021/6/3
 * <p>
 * 进货信息表单
 */
public class ImportGoodsDTO {
    @NotBlank(message = "商品名称不能为空")
    @Size(min = 1, max = 100)
    private String goodsName;
    @NotBlank(message = "商品类型不能为空")
    @Size(min = 1, max = 10)
    private String goodsType;
    @ParamMapping(targetClz = Import.class, ignore = true)
    @ParamMapping(targetClz = Goods.class, targetField = "cost")
    @NotNull(message = "商品成本不能为空")
    private Float goodsCost;
    @ParamMapping(targetClz = Import.class, ignore = true)
    @ParamMapping(targetClz = Goods.class, targetField = "price")
    @NotNull(message = "商品价格不能为空")
    private Float goodsPrice;
    @ParamMapping(targetClz = Import.class, ignore = true)
    @NotBlank(message = "生产日期不能为空")
    private String productionDate;
    @ParamMapping(targetClz = Import.class, ignore = true)
    @NotNull(message = "保质期不能为空")
    @Min(value = 1, message = "保质期最少为1天")
    @Max(value = 1825, message = "保质期需小于5年")
    private Integer duration;
    @ParamMapping(targetClz = Goods.class, ignore = true)
    @NotNull(message = "进货数量不能为空")
    @Min(value = 1, message = "至少进货1件商品")
    @Max(value = 10000, message = "库存小于10000")
    private Integer importGoodsSum;

    public ImportGoodsDTO() {
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName.trim();
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType.trim();
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
        this.productionDate = productionDate.trim();
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

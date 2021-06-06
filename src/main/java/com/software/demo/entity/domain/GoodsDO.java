package com.software.demo.entity.domain;

import java.math.BigDecimal;

/**
 * @author tinyplan
 * 2021/6/5
 */
public class GoodsDO {
    private String id;
    private String name;
    private String type;
    private Float cost;
    private Float price;
    private String productionDate;
    // 保质期(天)
    private Integer duration;
    // 过期时间
    private String expirationDate;
    private Integer stock;

    public GoodsDO() {
    }

    public GoodsDO(String id, String name, String type, Float cost, Float price, String productionDate, Integer duration, String expirationDate, Integer stock) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.price = price;
        this.productionDate = productionDate;
        this.duration = duration;
        this.expirationDate = expirationDate;
        this.stock = stock;
    }

    public GoodsDO(String id, String name, String type, BigDecimal cost, BigDecimal price, String productionDate, Integer duration, String expirationDate, Integer stock) {
        this(id, name, type, cost.floatValue(), price.floatValue(), productionDate, duration, expirationDate, stock);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}

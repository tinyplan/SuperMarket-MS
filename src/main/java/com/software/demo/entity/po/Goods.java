package com.software.demo.entity.po;

import java.math.BigDecimal;

/**
 * @author tinyplan
 * 2021/5/27
 * 2021/5/30:
 *      - 成员变量type类型更改为String
 *      - 去除成员变量stock，使类结构与数据库表结构相同
 *      - 添加新的构造方法, 以适配结果集映射
 */
public class Goods {
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

    public Goods(String id, String name, String type, Float cost, Float price, String productionDate, Integer duration, String expirationDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.price = price;
        this.productionDate = productionDate;
        this.duration = duration;
        this.expirationDate = expirationDate;
    }

    public Goods(String id, String name, String type, BigDecimal cost, BigDecimal price, String productionDate, Integer duration, String expirationDate) {
        this(id, name, type, cost.floatValue(), price.floatValue(), expirationDate, duration, expirationDate);
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
}

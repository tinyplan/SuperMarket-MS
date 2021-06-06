package com.software.demo.entity.vo;

/**
 * @author tinyplan
 * 2021/6/5
 */
public class GoodsVO {
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

    public GoodsVO() {
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

    @Override
    public String toString() {
        return "GoodsVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", cost=" + cost +
                ", price=" + price +
                ", productionDate='" + productionDate + '\'' +
                ", duration=" + duration +
                ", expirationDate='" + expirationDate + '\'' +
                ", stock=" + stock +
                '}';
    }
}

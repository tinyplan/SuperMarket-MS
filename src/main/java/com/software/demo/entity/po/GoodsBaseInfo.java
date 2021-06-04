package com.software.demo.entity.po;

public class GoodsBaseInfo {
    private String goods_base_id;
    private String goods_name;
    private String goods_type;

    public String getGoods_base_id() {
        return goods_base_id;
    }

    public void setGoods_base_id(String goods_base_id) {
        this.goods_base_id = goods_base_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    @Override
    public String toString() {
        return "GoodsBaseInfo{" +
                "goods_base_id='" + goods_base_id + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", goods_type='" + goods_type + '\'' +
                '}';
    }
}

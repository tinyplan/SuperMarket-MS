package com.software.demo.entity.po;

public class Imports {
    private String import_id;
    private String goods_base_id;
    private String import_date;
    private Integer import_goods_sum;
    private Integer stock;

    public Imports(){
    }

    public String getImport_id() {
        return import_id;
    }

    public void setImport_id(String import_id) {
        this.import_id = import_id;
    }

    public String getGoods_base_id() {
        return goods_base_id;
    }

    public void setGoods_base_id(String goods_base_id) {
        this.goods_base_id = goods_base_id;
    }

    public String getImport_date() {
        return import_date;
    }

    public void setImport_date(String import_date) {
        this.import_date = import_date;
    }

    public Integer getImport_goods_sum() {
        return import_goods_sum;
    }

    public void setImport_goods_sum(Integer import_goods_sum) {
        this.import_goods_sum = import_goods_sum;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Imports{" +
                "import_id='" + import_id + '\'' +
                ", goods_base_id='" + goods_base_id + '\'' +
                ", import_date='" + import_date + '\'' +
                ", import_goods_sum=" + import_goods_sum +
                ", stock=" + stock +
                '}';
    }
}

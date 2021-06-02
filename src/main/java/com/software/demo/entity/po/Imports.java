package com.software.demo.entity.po;

import com.software.demo.util.GoodsIdUtil;
import com.software.demo.util.TimeFormatUtil;

import java.time.LocalDateTime;

public class Imports {
    private String import_id;
    private String goods_base_id;
    private String import_date;
    private int import_goods_sum;

    public Imports(){
        this.import_date = LocalDateTime.now().format(TimeFormatUtil.FORMATTER);
        this.import_id = GoodsIdUtil.generateImportId();
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

    public int getImport_goods_sum() {
        return import_goods_sum;
    }

    public void setImport_goods_sum(int import_goods_sum) {
        this.import_goods_sum = import_goods_sum;
    }

    @Override
    public String toString() {
        return "Imports{" +
                "import_id='" + import_id + '\'' +
                ", goods_base_id='" + goods_base_id + '\'' +
                ", import_date='" + import_date + '\'' +
                ", import_goods_sum=" + import_goods_sum +
                '}';
    }
}

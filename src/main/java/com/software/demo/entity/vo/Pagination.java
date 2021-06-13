package com.software.demo.entity.vo;

import java.util.List;

/**
 * 封装分页数据
 *
 * @param <T>
 */
public class Pagination<T> {
    // 数据总量
    private Integer total;
    // 数据总列表
    private List<List<T>> tableData;

    public Pagination() {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<List<T>> getTableData() {
        return tableData;
    }

    public void setTableData(List<List<T>> tableData) {
        this.tableData = tableData;
    }
}

package com.software.demo.entity.vo;

import java.util.List;

/**
 * 封装分页数据
 *
 * @param <T>
 */
public class Pagination<T> {
    // 数据总量
    private Integer count;
    // 数据总列表
    private List<T> tableData;

    public Pagination(List<T> tableData) {
        this.count = tableData == null ? 0 : tableData.size();
        this.tableData = tableData;
    }

    public Integer getCount() {
        return count;
    }

    public List<T> getTableData() {
        return tableData;
    }
}

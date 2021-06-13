package com.software.demo.util;

import com.software.demo.entity.vo.Pagination;

import java.util.ArrayList;
import java.util.List;

/**
 * 逻辑分页分页工具类
 */
public class PaginationUtil {

    /**
     * 逻辑分页
     *
     * @param dataList 数据列表
     * @param pageSize 页面容量
     */
    public static <T> List<List<T>> getLogicPagination(List<T> dataList, Integer pageSize) {
        int total = dataList.size();
        List<List<T>> result = new ArrayList<>();
        int offsetIndex = 0;
        // 判断下一次是否越界
        while (offsetIndex + pageSize < total) {
            List<T> tmp = new ArrayList<>();
            for (int i = offsetIndex; i < offsetIndex + pageSize; i++){
                tmp.add(dataList.get(i));
            }
            result.add(tmp);
            offsetIndex += pageSize;
        }
        // 扫尾
        int rest = total - offsetIndex;
        List<T> restList = new ArrayList<>();
        for (int i = offsetIndex; i < offsetIndex + rest; i++){
            restList.add(dataList.get(i));
        }
        result.add(restList);
        return result;
    }

    public static <T> Pagination<T> getPagination(List<T> dataList, Integer limit) {
        Pagination<T> pagination = new Pagination<>();
        if (dataList == null) {
            pagination.setTotal(0);
            pagination.setTableData(new ArrayList<>());
        }else {
            pagination.setTotal(dataList.size());
            pagination.setTableData(PaginationUtil.getLogicPagination(dataList, limit));
        }
        return pagination;
    }

}

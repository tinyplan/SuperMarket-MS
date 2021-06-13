package com.software.demo.controller;

import com.software.demo.entity.ApiResult;
import com.software.demo.entity.ResultStatus;
import com.software.demo.entity.vo.Pagination;
import com.software.demo.entity.vo.SalesRecordVO;
import com.software.demo.entity.vo.StockRecordVO;
import com.software.demo.service.SalesRecordService;
import com.software.demo.service.StockRecordService;
import com.software.demo.util.PaginationUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yjn
 * 2021/06/13
 */
@RestController
@RequestMapping("/sales")
public class SalesRecordController {

    @Resource(name = "salesRecordServiceImpl")
    private SalesRecordService salesRecordService;

    @GetMapping("/getAll")
    public ApiResult<Pagination<SalesRecordVO>> getAllSalesRecord(@RequestParam("pageSize") Integer limit) {
        return new ApiResult<>(ResultStatus.RES_SUCCESS,
                PaginationUtil.getPagination(salesRecordService.queryAllRecord(), limit));
    }
}

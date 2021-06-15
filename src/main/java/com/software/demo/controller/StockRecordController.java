package com.software.demo.controller;

import com.software.demo.annotation.Authorization;
import com.software.demo.entity.ApiResult;
import com.software.demo.entity.ResultStatus;
import com.software.demo.entity.vo.Pagination;
import com.software.demo.entity.vo.StockRecordVO;
import com.software.demo.service.StockRecordService;
import com.software.demo.util.PaginationUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tinyplan
 * 2021/6/12
 */
@RestController
@RequestMapping("/stock")
public class StockRecordController {

    @Resource(name = "stockRecordServiceImpl")
    private StockRecordService stockRecordService;

    @GetMapping("/getAll")
    @Authorization
    public ApiResult<Pagination<StockRecordVO>> getAllStockRecord(@RequestParam("pageSize") Integer limit) {
        return new ApiResult<>(ResultStatus.RES_SUCCESS,
                PaginationUtil.getPagination(stockRecordService.queryAllRecord(), limit));
    }

}

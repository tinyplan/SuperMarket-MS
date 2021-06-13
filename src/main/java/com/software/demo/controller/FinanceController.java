package com.software.demo.controller;

import com.software.demo.entity.ApiResult;
import com.software.demo.entity.ResultStatus;
import com.software.demo.entity.vo.FinanceSummaryVO;
import com.software.demo.entity.vo.Pagination;
import com.software.demo.service.GoodsService;
import com.software.demo.util.PaginationUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tinyplan
 * 2021/6/13
 */
@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Resource(name = "goodsServiceImpl")
    private GoodsService goodsService;

    @GetMapping("/summary")
    public ApiResult<Pagination<FinanceSummaryVO>> getFinanceSummary(@RequestParam("type") String type,
                                                                     @RequestParam("pageSize") Integer limit) {
        if (!"day".equals(type) && !"month".equals(type)) {
            return new ApiResult<>(ResultStatus.RES_FAIL, null);
        }
        return new ApiResult<>(ResultStatus.RES_SUCCESS,
                PaginationUtil.getPagination(goodsService.queryFinanceSummary(type), limit));
    }


}

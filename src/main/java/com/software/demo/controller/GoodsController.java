package com.software.demo.controller;

import com.software.demo.annotation.Authorization;
import com.software.demo.entity.ApiResult;
import com.software.demo.entity.ResultStatus;
import com.software.demo.entity.dto.*;
import com.software.demo.entity.po.Goods;
import com.software.demo.entity.vo.GoodsVO;
import com.software.demo.entity.vo.Pagination;
import com.software.demo.service.GoodsService;
import com.software.demo.util.ObjectTransformUtil;
import com.software.demo.util.PaginationUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tinyplan
 * 2021/6/3
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource(name = "goodsServiceImpl")
    private GoodsService goodsService;

    /**
     * 增加新的商品基础信息
     */
    @PostMapping("/base/add")
    @Authorization
    public ApiResult<Object> addGoodsBaseInfo(@RequestBody @Validated GoodsBaseInfoDTO dto) {
        // 数据校验
        // 商品名称可以为空，全数字，全特殊字符
        // 商品名称可以为超长字符串
        String goodsName = dto.getName();
        if (Pattern.matches("^[0-9]*$", goodsName) || Pattern.matches("^[+\\-*/]*$", goodsName)) {
            return new ApiResult<>(ResultStatus.RES_FAIL, "商品名称非法", null);
        }
        boolean success = goodsService.addGoodsBaseInfo(dto);
        if (!success) {
            return new ApiResult<>(ResultStatus.RES_FAIL, null);
        }
        return new ApiResult<>(ResultStatus.RES_SUCCESS, null);
    }

    /**
     * 商品进货
     */
    @PostMapping("/import")
    @Authorization
    public ApiResult<Object> importGoods(@RequestBody @Validated ImportGoodsDTO dto) {
        String goodsName = dto.getGoodsName();
        if (Pattern.matches("^[0-9]*$", goodsName) || Pattern.matches("^[+\\-*/]*$", goodsName)) {
            return new ApiResult<>(ResultStatus.RES_FAIL, "商品名称非法", null);
        }
        // Float类型无法校验，直接在这里判断
        if (dto.getGoodsCost() <= 0) {
            return new ApiResult<>(ResultStatus.RES_FAIL, "成本必须大于0", null);
        }
        if (dto.getGoodsPrice() <= 0) {
            return new ApiResult<>(ResultStatus.RES_FAIL, "售价必须大于0", null);
        }
        boolean success = goodsService.importGoods(dto);
        if (!success) {
            return new ApiResult<>(ResultStatus.RES_FAIL, null);
        }
        return new ApiResult<>(ResultStatus.RES_SUCCESS, null);
    }

    /**
     * 修改商品信息
     */
    @PostMapping("/modify")
    @Authorization
    public ApiResult<Object> modifyGoodsInfo(@RequestBody ModifyGoodsDTO dto) {
        if (dto.getGoodsPrice() <= 0.0f || dto.getGoodsPrice() > 10000.0f) {
            return new ApiResult<>(ResultStatus.RES_FAIL, "售价应大于等于0, 小于10000");
        }
        boolean success = goodsService.modifyGoodsInfo(dto);
        if (!success) {
            return new ApiResult<>(ResultStatus.RES_FAIL, null);
        }
        return new ApiResult<>(ResultStatus.RES_SUCCESS, null);
    }

    /**
     * 商品出售
     */
    @PostMapping("/sell")
    @Authorization
    public ApiResult<Object> sellGoods(@RequestBody @Validated SellGoodsDTO dto) {
        boolean success = goodsService.sellGoods(dto);
        if (!success) {
            return new ApiResult<>(ResultStatus.RES_FAIL, null);
        }
        return new ApiResult<>(ResultStatus.RES_SUCCESS, null);
    }

    /**
     * 商品退款
     */
    @PostMapping("/refund")
    @Authorization
    public ApiResult<Object> refund(@RequestBody @Validated RefundGoodsDTO dto) {
        boolean success = goodsService.refundGoods(dto);
        if (!success) {
            return new ApiResult<>(ResultStatus.RES_FAIL, null);
        }
        return new ApiResult<>(ResultStatus.RES_SUCCESS, null);
    }

    /**
     * 获取商品信息
     */
    @GetMapping("/getAll")
    @Authorization
    public ApiResult<Pagination<GoodsVO>> queryAllGoods(@RequestParam("pageSize") Integer limit,
                                                        HttpServletRequest request) {
        return new ApiResult<>(ResultStatus.RES_SUCCESS,
                PaginationUtil.getPagination(goodsService.queryGoods(limit), limit));
    }


}

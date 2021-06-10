package com.software.demo.controller;

import com.software.demo.annotation.Authorization;
import com.software.demo.entity.ApiResult;
import com.software.demo.entity.ResultStatus;
import com.software.demo.entity.dto.GoodsBaseInfoDTO;
import com.software.demo.entity.dto.ImportGoodsDTO;
import com.software.demo.entity.dto.ModifyGoodsDTO;
import com.software.demo.entity.dto.SellGoodsDTO;
import com.software.demo.entity.po.Goods;
import com.software.demo.entity.vo.GoodsVO;
import com.software.demo.entity.vo.Pagination;
import com.software.demo.service.GoodsService;
import com.software.demo.util.ObjectTransformUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    public ApiResult<Object> addGoodsBaseInfo(@RequestBody GoodsBaseInfoDTO dto) {
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
    public ApiResult<Object> importGoods(@RequestBody ImportGoodsDTO dto) {
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
        boolean success = goodsService.modifyGoodsInfo(dto);
        if (!success) {
            return new ApiResult<>(ResultStatus.RES_FAIL, null);
        }
        return new ApiResult<>(ResultStatus.RES_SUCCESS, null);
    }

    @PostMapping("/sell")
    @Authorization
    public ApiResult<Object> sellGoods(@RequestBody SellGoodsDTO dto) {
        boolean success = goodsService.sellGoods(dto);
        if (!success) {
            return new ApiResult<>(ResultStatus.RES_FAIL, null);
        }
        return new ApiResult<>(ResultStatus.RES_SUCCESS, null);
    }

    @PostMapping("/refund")
    @Authorization
    public ApiResult<Object> refund() {
        return null;
    }

    /**
     * 获取商品信息
     */
    @GetMapping("/getAll")
    @Authorization
    public ApiResult<Pagination<GoodsVO>> queryAllGoods(@RequestParam("pageSize") Integer limit,
                                                        HttpServletRequest request) {
        return new ApiResult<>(ResultStatus.RES_SUCCESS,
                new Pagination<>(goodsService.queryGoods(limit)));
    }


}

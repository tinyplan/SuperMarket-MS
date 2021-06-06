package com.software.demo.controller;

import com.software.demo.annotation.Authorization;
import com.software.demo.entity.ApiResult;
import com.software.demo.entity.ResultStatus;
import com.software.demo.entity.dto.ImportGoodsDTO;
import com.software.demo.entity.dto.ModifyGoodsDTO;
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

    @PostMapping("/import")
    @Authorization
    public ApiResult<Object> importGoods(@RequestBody ImportGoodsDTO dto) {
        return null;
    }

    @PostMapping("/modify")
    public ApiResult<Object> modifyGoodsInfo(@RequestBody ModifyGoodsDTO dto) {
        Goods goods = ObjectTransformUtil.transform(dto, Goods.class);
        boolean success = goodsService.modifyGoodsInfo(goods);
        if (!success) {
            return new ApiResult<>(ResultStatus.RES_FAIL, null);
        }
        return new ApiResult<>(ResultStatus.RES_SUCCESS, null);
    }

    @GetMapping("/getAll")
    @Authorization
    public ApiResult<Pagination<GoodsVO>> queryAllGoods(@RequestParam("page") Integer page,
                                                        @RequestParam("limit") Integer limit,
                                                        HttpServletRequest request) {
        return new ApiResult<>(ResultStatus.RES_SUCCESS,
                new Pagination<>(goodsService.queryGoods(page, limit)));
    }


}

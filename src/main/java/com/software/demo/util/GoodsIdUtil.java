package com.software.demo.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 商品ID工具类
 * <p>
 * 2021-5-30: goods_id 为 4位base_id + "-" + 8位import_id
 */
public class GoodsIdUtil {

    public static final String GOODS_ID_SEPARATOR = "-";

    /**
     * 生成10位importId，用来与货品baseId一起拼接成goodsId
     *
     * @return 商品的import_id
     */
    private static String generateImportId() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    /**
     * 生成第一次进货的商品的4位BaseId
     *
     * @param goodsName 商品名称
     * @return 商品的base_id
     */
    private static String generateBaseId(String goodsName) {
        // 这里hash码取前4位, 所以使用除法
        // 取后四位的话(也就是取余操作), 可能出现前几位为0的情况, 使计算后的结果不足4位
        return goodsName.hashCode() / 100000 + "";
    }

    /**
     * 生成商品goods_id, 仅在商品第一次进货时使用
     *
     * @param goodsName 商品名称
     * @return 商品的goods_id
     */
    public static String generateGoodsId(String goodsName) {
        return GoodsIdUtil.generateBaseId(goodsName)
                + GOODS_ID_SEPARATOR
                + GoodsIdUtil.generateImportId();
    }

    /**
     * 通过GoodsId获得该商品的BaseId
     *
     * @param goodsId 商品ID
     * @return 商品的4位base_id
     */
    public static String getBaseIdFromGoodsId(String goodsId) {
        return goodsId.substring(0, 4);
    }

    /**
     * 通过GoodsId获得该商品的ImportID
     *
     * @param goodsId 商品ID
     * @return 商品的8位import_id
     */
    public static String getImportIdFromGoodsId(String goodsId) {
        return goodsId.substring(5);
    }

    public static void main(String[] args) {
        String abc = "乐事薯条";
        String goodId = GoodsIdUtil.generateGoodsId(abc);
        System.out.println(goodId);
        System.out.println(GoodsIdUtil.getBaseIdFromGoodsId(goodId));
        System.out.println(GoodsIdUtil.getImportIdFromGoodsId(goodId));
    }
}

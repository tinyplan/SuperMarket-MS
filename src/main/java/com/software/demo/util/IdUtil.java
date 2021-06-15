package com.software.demo.util;

import org.springframework.util.DigestUtils;

/**
 * 商品ID工具类
 * <p>
 * 2021-5-30: goods_id 为 4位base_id + "-" + import_id
 */
public class IdUtil {

    public static final String GOODS_ID_SEPARATOR = "-";

    /**
     * 生成8位importId
     *
     * @return 商品的import_id
     */
    public static String generateImportId(Integer maxId) {
        return TimeUtil.nowDate("yyyyMMdd") + GOODS_ID_SEPARATOR + checkId(maxId);
    }

    /**
     * 生成第一次进货的商品的4位BaseId
     *
     * @param goodsName 商品名称
     * @return 商品的base_id
     */
    public static String generateBaseId(String goodsName) {
        String md5 = DigestUtils.md5DigestAsHex(goodsName.getBytes());
        return md5.substring(0, 6);
    }

    /**
     * 生成商品goods_id
     *
     * @return 商品的goods_id
     */
    public static String generateGoodsId(String importId, String goodsBaseId) {
        return goodsBaseId + GOODS_ID_SEPARATOR + importId;
    }

    public static String generateRecordId(Integer maxId) {
        return TimeUtil.nowDate("yyyyMMdd") + GOODS_ID_SEPARATOR + checkId(maxId);
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

    public static Integer checkId(Integer curMaxId) {
        return curMaxId == null ? 0 : curMaxId + 1;
    }

}

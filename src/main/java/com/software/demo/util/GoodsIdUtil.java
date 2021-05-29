package com.software.demo.util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class GoodsIdUtil {

    //Goods_id格式：4位base_id拼接上10位import_id

    /**
     * 生成10位importId，用来与货品baseId一起拼接成goodsId
     * @return
     */
    public static String generateImportId(){
        String importId;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmm");
        Date date= new Date();
        importId = simpleDateFormat.format(date);
        return importId;
    }

    /**
     * 生成第一次进货的商品的4位BaseId
     * @param goodsName 商品名称
     * @return
     */
    public static String generateBaseId(String goodsName){
        return goodsName.hashCode()%10000 + "";
    }

    /**
     * 通过GoodsId获得该商品的BaseId
     * @param goodsId 商品ID
     * @return
     */
    public static String getBaseIdFromGoodsId(String goodsId){
        String baseId = "";
        baseId = goodsId.substring(0,4);
        return baseId;
    }

    /**
     * 通过GoodsId获得该商品的ImportID
     * @param goodsId 商品ID
     * @return
     */
    public static String getImportIdFromGoodsId(String goodsId){
        String importId = "";
        importId = goodsId.substring(4);
        return importId;
    }

    public static void main(String[] args) {
        String abc ="乐事薯条";
        String goodId = GoodsIdUtil.generateBaseId(abc) + GoodsIdUtil.generateImportId();
        System.out.println(goodId);
        System.out.println(GoodsIdUtil.getBaseIdFromGoodsId(goodId));
        System.out.println(GoodsIdUtil.getImportIdFromGoodsId(goodId));
    }
}

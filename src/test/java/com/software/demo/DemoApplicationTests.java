package com.software.demo;

import com.software.demo.dao.GoodsBaseInfoMapper;
import com.software.demo.dao.GoodsMapper;
import com.software.demo.dao.ImportMapper;
import com.software.demo.entity.po.Goods;
import com.software.demo.util.IdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    ImportMapper importMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsBaseInfoMapper infoMapper;

    @Test
    void insertGoodsInfo(){
        // GoodsBaseInfo info = new GoodsBaseInfo();
        // info.setGoods_name("小熊饼干");
        // info.setGoods_base_id(GoodsIdUtil.generateGoodsId("小熊饼干"));
        // info.setGoods_type("饼干");
        // infoMapper.insertGoodsBaseInfo(info);
    }

    @Test
    void selectGoodsInfo(){
        // GoodsBaseInfo info = infoMapper.selectGoodsBaseInfo(GoodsIdUtil.generateGoodsId("小熊饼干"));
        // System.out.println(info);
    }

    @Test
    void updateGoodsInfo(){
        // GoodsBaseInfo info = new GoodsBaseInfo();
        // info.setGoods_name("小熊发斯蒂芬");
        // info.setGoods_base_id(GoodsIdUtil.generateBaseId("小熊发斯蒂芬"));
        // info.setGoods_type("饼干");
        // infoMapper.updateGoodsBaseInfo("7312-20210604",info);
    }

    @Test
    void insertGoods(){
        // float a = 10.5f;
        // Goods goods = new Goods(IdUtil.generateGoodsId("小熊饼干"),"小熊饼干","饼干",
        //         a,a+10,"2015-3-3",30,"2016-6-7");
        // goodsMapper.insertGoods(goods);
    }

    @Test
    void selectAllGoods(){
        // List<Goods> goods = new ArrayList<>();
        // goods = goodsMapper.queryAllGoods();
        // System.out.println(goods.toString());
    }

    @Test
    void updateGoods(){
        // Goods goods = new Goods(IdUtil.generateGoodsId("小熊饼干"),"小熊饼干","饼干",
        //         10f,105f,"2015-3-3",40,"2016-6-7");
        // goodsMapper.updateGoods(goods);
    }

    @Test
    void deleteGoods(){
        // goodsMapper.deleteGoods(IdUtil.generateGoodsId("小熊饼干"));
    }

    @Test
    void insertImportTest() {
        // Import anImport = new Import();
        // anImport.setGoods_base_id("26");
        // anImport.setImport_goods_sum(13);
        // System.out.println(anImport.getImport_date());
        // importMapper.insertImport(anImport);
    }

    @Test
    void selectAllImportsTest(){
        // List<Import> anImports = new ArrayList<>();
        // anImports = importMapper.selectAllImports();
        // System.out.println(anImports.toString());
    }

    @Test
    void updateImportTest(){
        // importMapper.updateImport("9591","26",3);

    }

}

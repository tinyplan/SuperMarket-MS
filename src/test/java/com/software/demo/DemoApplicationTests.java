package com.software.demo;

import com.software.demo.dao.ImportMapper;
import com.software.demo.entity.po.Imports;
import com.software.demo.util.GoodsIdUtil;
import com.software.demo.util.TimeFormatUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    ImportMapper importMapper;

    @Test
    void insertImportTest() {
        Imports imports = new Imports();
        imports.setGoods_base_id("26");
        imports.setImport_goods_sum(13);
        System.out.println(imports.getImport_date());
        importMapper.insertImport(imports);
    }

    @Test
    void selectAllImportsTest(){
        List<Imports> imports = new ArrayList<>();
        imports = importMapper.getAllImports();
        System.out.println(imports.toString());
    }

    @Test
    void updateImportTest(){
        importMapper.updateImport("9591","26",3);

    }

}

package com.software.demo.dao;

import com.software.demo.entity.po.Import;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImportMapper {

    Integer maxId();

    Integer insertImport(Import anImport);

    List<Import> queryAllImports();

    // Integer updateImport(Import updateInfo);

}

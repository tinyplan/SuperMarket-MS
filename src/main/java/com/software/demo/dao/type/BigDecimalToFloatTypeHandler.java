package com.software.demo.dao.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author tinyplan
 * 2021/6/7
 *
 * 数据库的DECIMAL类型与java的Float类型的转换
 */
public class BigDecimalToFloatTypeHandler extends BaseTypeHandler<Float> {

    /**
     * 将java类型转换为jdbc类型
     * 在更新表的时候会用到
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Float parameter, JdbcType jdbcType) throws SQLException {
        ps.setBigDecimal(i, new BigDecimal(parameter));
    }

    // 下面三个方法都是在查询时, 将jdbc类型转换为java类型
    @Override
    public Float getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.getBigDecimal(columnName).floatValue();
    }

    @Override
    public Float getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getBigDecimal(columnIndex).floatValue();
    }

    @Override
    public Float getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.getBigDecimal(columnIndex).floatValue();
    }
}

package com.software.demo.util;

import com.software.demo.annotation.ParamMapping;
import com.software.demo.entity.ResultStatus;
import com.software.demo.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * @author tinyplan
 * 2021/6/5
 * <p>
 * 对象转换具体实现
 */
public class ObjectTransformUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(ObjectTransformUtil.class);
    private static final String FORMAT_PREPARE_STATEMENT = "#{%s}, ";

    /**
     * 类转换
     *
     * @param source    源对象
     * @param targetClz 目标对象Class
     * @param <S>       源类
     * @param <T>       目标类
     * @return 目标对象的实例
     */
    public static <S, T> T transform(S source, Class<T> targetClz) {
        Class<?> sourceClz = source.getClass();
        // 创建目标对象的实例
        T target = null;
        try {
            target = targetClz.newInstance();
        } catch (Exception e) {
            throw new BusinessException(ResultStatus.RES_FAIL, "目标对象创建失败");
        }
        // 遍历源对象全部字段
        for (Field sourceField : sourceClz.getDeclaredFields()) {
            Field targetField = findAssignTargetField(sourceField, targetClz);
            // 忽略从源对象中找不到对应字段的情况
            // 也就是说只会将匹配成功的值进行赋值
            if (targetField == null) {
                continue;
            }
            // 缓存原来的访问修饰
            boolean sourceFieldAccessible = sourceField.isAccessible();
            boolean targetFieldAccessible = targetField.isAccessible();
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
            // 赋值
            try {
                targetField.set(target, sourceField.get(source));
            } catch (IllegalAccessException e) {
                LOGGER.warn("没有对应的权限: " + targetField.getName());
            }
            // 恢复访问权限
            sourceField.setAccessible(sourceFieldAccessible);
            targetField.setAccessible(targetFieldAccessible);
        }
        return target;
    }

    /**
     * 寻找指定的目标字段名
     * 注解中配置的信息优先
     *
     * @param field     源对象字段
     * @param targetClz 指定的目标类
     * @return 若配置了目标字段, 返回配置的字段名称; 若没有, 返回源字段的名称
     */
    private static String findAssignTargetFieldName(Field field, Class<?> targetClz) {
        ParamMapping[] annotations = field.getAnnotationsByType(ParamMapping.class);
        for (ParamMapping annotation : annotations) {
            if (annotation.targetClz() == targetClz) {
                if (!annotation.ignore()) {
                    // 若没有指定目标字段, 则返回当前字段名
                    if ("".equals(annotation.targetField())) {
                        return field.getName();
                    }
                } else {
                    // 忽略该字段
                    LOGGER.info("忽略字段: " + field.getName());
                    return null;
                }
                return annotation.targetField();
            }
        }
        return field.getName();
    }

    public static Field findAssignTargetField(Field field, Class<?> targetClz) {
        Field targetField = null;
        try {
            String targetFieldName = findAssignTargetFieldName(field, targetClz);
            if (targetFieldName == null) {
                return null;
            }
            targetField = targetClz.getDeclaredField(targetFieldName);
        } catch (NoSuchFieldException e) {
            LOGGER.warn("未在[" + targetClz.getName() + "]找到字段: " + field.getName());
        }
        return targetField;
    }

    /**
     * 写mybatis时专用, 业务里面一般不会用到, 除非自己去拼接sql
     * 自动根据类生成类似:
     * (#{id}, #{name}, #{type}, #{cost})的语句
     *
     * @param targetClz 目标类
     * @return
     */
    public static String getFieldForPreparedStatement(Class<?> targetClz) {
        StringBuilder sb = new StringBuilder();
        for (Field field : targetClz.getDeclaredFields()) {
            sb.append(String.format(FORMAT_PREPARE_STATEMENT, field.getName()));
        }
        return "(" + sb.substring(0, sb.length() - 2) + ")";
    }

}

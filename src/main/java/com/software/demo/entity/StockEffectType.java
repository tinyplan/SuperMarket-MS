package com.software.demo.entity;

/**
 * @author tinyplan
 * 2021/6/9
 */
public enum StockEffectType {
    ADD(1, "+"),
    SUBTRACT(-1, "-");

    private final Integer key;
    private final String desc;

    StockEffectType(Integer key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public Integer getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }
}

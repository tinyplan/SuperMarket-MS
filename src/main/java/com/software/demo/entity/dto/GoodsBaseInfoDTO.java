package com.software.demo.entity.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author tinyplan
 * 2021/6/8
 */
public class GoodsBaseInfoDTO {
    @NotBlank(message = "商品名称不能为空")
    @Size(min = 1, max = 100)
    private String name;
    @NotBlank(message = "商品类型不能为空")
    @Size(min = 1, max = 10)
    private String type;

    public GoodsBaseInfoDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type.trim();
    }
}

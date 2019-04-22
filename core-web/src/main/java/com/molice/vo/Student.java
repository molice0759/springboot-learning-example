package com.molice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author molice
 * @date 2019/3/26
 **/
@ApiModel
public class Student {

    @ApiModelProperty(value = "学生名字", required = true)
    @NotBlank(message = "学生名字不能为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

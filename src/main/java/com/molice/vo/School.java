package com.molice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author molice
 * @date 2019/3/26
 **/
@ApiModel
public class School {

    @ApiModelProperty(value = "学校名称", required = true)
    @NotBlank(message = "学校名称不能为空")
    private String name;

    @Valid
    @ApiModelProperty(value = "学生", required = true)
    @NotNull(message = "学生不能为空")
    private Student student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

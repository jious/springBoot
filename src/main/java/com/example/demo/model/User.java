package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户实体")
@Data
public class User {
    /*
    用户 id
     */
    @ApiModelProperty("用户id")
    private int id;

    /*
    用户名
     */
    @ApiModelProperty("用户姓名")
    private String name;

    /*
    用户地址
     */
    @ApiModelProperty("用户地址")
    private String aadreess;
}

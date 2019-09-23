package com.example.demo.controller;
import	java.util.jar.Attributes.Name;

import com.example.demo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

@RestController //控制器组件
@RequestMapping("/user")
@Api(tags = "用户相关接口", value = "提供用户相关的Rest API")
public class UserController {

 @ApiOperation(value = "新增用户接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 @PostMapping("/add")
 public boolean addUser(@RequestBody User user)   {
     return false;
 }

    @ApiOperation("通过id查找用户接口")
    @GetMapping("/find/{id}")
    public User findById(@PathVariable("id") int id) {
        return new User();
    }

    @ApiOperation("更新用户信息接口")
    @PatchMapping("/update")
    public boolean update(@RequestBody User user) {
        return true;
    }

    @ApiOperation("删除用户接口")
    @DeleteMapping("/delete/{id}")
//    @ApiIgnore
    public boolean delete(@PathVariable("id") int id) {
        return true;
    }

}

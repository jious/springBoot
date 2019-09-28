package test.controller;/*
    @author : parry
    @Create : 2019-09-28 15:11
*/

import boat.commons.orika.Orika;
import boat.web.response.CloudApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.api.UserApiPost;
import test.model.UserModel;
import test.api.UserApiPatch;
import test.projection.UserProjection;
import test.service.UserService;

import static jdk.nashorn.internal.objects.NativeDebug.map;

@Api(tags = "用户列表-API")// 标题
    @RequestMapping("user:user")//请求路径
    @RestController
    public class userController {
        @Autowired
        private UserService userService;

    @ApiOperation(httpMethod = "POST", value = "增加", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CloudApiResponse<UserProjection> create(@Validated @RequestBody UserApiPost api) {
        CloudApiResponse<UserProjection> apiResponse = new CloudApiResponse<>();
        UserModel resultModel = userService.save(Orika.map(api, UserModel.class));
        apiResponse.setData(resultModel, UserProjection.class);
        apiResponse.setMsg("添加成功");
        return apiResponse;
    }

    @ApiOperation(httpMethod = "PATCH", value = "更新", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CloudApiResponse<UserProjection> update(@PathVariable Integer id,
                                            @Validated @RequestBody UserApiPatch api) {
        CloudApiResponse<UserProjection> apiResponse = new CloudApiResponse<>();
        UserModel userModel = Orika.map(api, UserModel.class);
        userModel.setId(id);
        UserModel resultModel = userService.update(userModel);
        apiResponse.setData(resultModel, UserProjection.class);
        apiResponse.setMsg("更新成功");
        return apiResponse;
    }

    @ApiOperation(httpMethod = "DELETE", value = "删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CloudApiResponse<UserProjection> delete(@PathVariable Integer id) {
        CloudApiResponse<UserProjection> apiResponse = new CloudApiResponse<>();
        UserModel userModel = new UserModel();
        userModel.setId(id);
        userService.deleteById(userModel);
        apiResponse.setMsg("删除成功");
        return apiResponse;
    }

    @ApiOperation(httpMethod = "GET", value = "查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CloudApiResponse<UserProjection> findById(@PathVariable Integer id) {
        CloudApiResponse<UserProjection> apiResponse = new CloudApiResponse<>();
        UserModel model = userService.findById(id);
        apiResponse.setData(model, UserProjection.class);
        return apiResponse;
        }
    }

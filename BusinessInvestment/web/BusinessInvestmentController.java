package logic.BusinessInvestment.web;/*
    @author : parry
    @Create : 2019-09-29 09:28
*/

import boat.web.response.CloudApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import logic.BusinessInvestment.api.BusinessInvestmentApiGet;
import logic.BusinessInvestment.api.BusinessInvestmentPatch;
import logic.BusinessInvestment.api.BusinessInvestmentPost;
import logic.BusinessInvestment.model.BusinessInvestmentModel;
import logic.BusinessInvestment.projection.BusinessInvestmentProjection;
import logic.BusinessInvestment.service.BusinessInvestmentService;
import logic.cooperative.api.CooperativeApiGet;
import logic.cooperative.api.CooperativeApiPost;
import logic.cooperative.mode.CooperativeModel;
import logic.cooperative.projection.CooperativeProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import static boat.commons.orika.Orika.map;

@Api(tags = "招商管理-API")
@RestController
@RequestMapping("business:investment")
public class BusinessInvestmentController {

    @Autowired
    private BusinessInvestmentService busines;

    @ApiOperation(httpMethod = "GET", value = "分页", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "name", value = "名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "status", value = "状态：false禁用，true启用", paramType = "query", dataType = "Boolean"),
            @ApiImplicitParam(name = "page", value = "分页.page", paramType = "query", dataType = "int", defaultValue = "0"),
            @ApiImplicitParam(name = "size", value = "分页.size", paramType = "query", dataType = "int", defaultValue = "20")
    })
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CloudApiResponse<Page<BusinessInvestmentProjection>> findPage(@ApiIgnore BusinessInvestmentApiGet api,
                                                                  @ApiIgnore Pageable pageable) {
        CloudApiResponse<Page<BusinessInvestmentProjection>> apiResponse = new CloudApiResponse<>();
        Page<BusinessInvestmentModel> page = busines.findPage(map(api, BusinessInvestmentModel.class), pageable);
        apiResponse.setData(page, BusinessInvestmentProjection.class);
        return apiResponse;
    }

    @ApiOperation(httpMethod = "POST", value = "创建", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CloudApiResponse<BusinessInvestmentProjection> create(@Validated @RequestBody BusinessInvestmentPost api) {
        CloudApiResponse<BusinessInvestmentProjection> apiResponse = new CloudApiResponse<>();
        BusinessInvestmentModel model = busines.save(map(api, BusinessInvestmentModel.class));
        apiResponse.setData(model, BusinessInvestmentProjection.class);
        return apiResponse;
    }

    @ApiOperation(httpMethod = "PATCH", value = "更新", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CloudApiResponse<BusinessInvestmentProjection> update(@PathVariable Integer id,
                                                   @Validated @RequestBody BusinessInvestmentPatch api) {
        CloudApiResponse<BusinessInvestmentProjection> apiResponse = new CloudApiResponse<>();
        BusinessInvestmentModel model =map(api, BusinessInvestmentModel.class);
        model.setId(id);
        BusinessInvestmentModel resultModel = busines.update(model);
        apiResponse.setData(resultModel, BusinessInvestmentProjection.class);
        return apiResponse;
    }
}

package test.api;/*
    @author : parry
    @Create : 2019-09-28 15:26
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserApiPatch {

    @ApiModelProperty(value = "房源名称")
    private String userName;
}

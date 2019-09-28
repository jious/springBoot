package test.projection;/*
    @author : parry
    @Create : 2019-09-28 15:26
*/

import io.swagger.annotations.ApiModelProperty;

public interface UserProjection {
    @ApiModelProperty(value = "ID", required = true)
    Integer getId();

    @ApiModelProperty(value = "姓名", required = true)
    String getUserName();
}

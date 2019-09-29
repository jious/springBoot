package logic.BusinessInvestment.projection;/*
import	java.awt.Desktop.Action;
    @author : parry
    @Create : 2019-09-29 09:49
*/

import io.swagger.annotations.ApiModelProperty;
import logic.platform.constants.PlatformType;

import java.util.Date;

public interface BusinessInvestmentProjection {

    @ApiModelProperty(value = "id")
    Integer getId();

    @ApiModelProperty(value = "招商名称")
    String getName();

    @ApiModelProperty(value = "照片")
    String getImage();

    @ApiModelProperty(value = "状态")
    boolean getStatus();

    @ApiModelProperty(value = "详情")
    String getNote();

    @ApiModelProperty(value = "创建时间")
    Date getCreateTime();


}

package logic.BusinessInvestment.api;/*
    @author : parry
    @Create : 2019-09-29 09:28
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessInvestmentPatch {

    @NotBlank(message = "{BusinessInvestmentPost.name.none}")
    @ApiModelProperty(value = "招商名称",required = true)
    private String name;

    @NotBlank(message = "{BusinessInvestmentPost.image.none}")
    @ApiModelProperty(value = "图片")
    private String image;

    @ApiModelProperty(value = "状态：true启用,false禁用")
    private Boolean status;

    @ApiModelProperty(value = "招商详情")
    private String note;
}

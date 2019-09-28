package test.api;/*
    @author : parry
    @Create : 2019-09-28 15:25
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserApiPost {
  @NotBlank(message = "{UserApiPost.userName.none}") // 只能作用在String上，不能为null，而且调用trim()后，长度必须大于0
  @ApiModelProperty(value = "姓名", required = true)
  private String userName;
    }
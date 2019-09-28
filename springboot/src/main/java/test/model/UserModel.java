package test.model;/*
    @author : parry
    @Create : 2019-09-28 15:12
*/

import boat.data.model.Paging;
import boat.mybatis.annotation.Column;
import boat.mybatis.annotation.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "user")

public class UserModel extends Paging {
    /**
     * ID
     */
    @Column(id = true)
    private Integer id;

    /**
     * 房源名称
     */
    @Column(name = "userName")
    private String userName;


}

package logic.BusinessInvestment.model;/*
import	java.util.jar.Attributes.Name;
    @author : parry
    @Create : 2019-09-29 09:48
*/

import boat.data.model.Paging;
import boat.mybatis.annotation.Column;
import boat.mybatis.annotation.CreationTimestamp;
import boat.mybatis.annotation.Table;
import logic.platform.constants.PlatformType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "businessInvestment")
public class BusinessInvestmentModel extends Paging {

    @Column(id = true)
    private Integer id;

    /**
     * 招商名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 照片
     */
    @Column(name = "image")
    private String image;

    /**
     * 报名人数
     */
    @Column(name = "peoplesNum")
    private String peoplesNum;

    @Column(name = "status")
    private Boolean status;

    /**
     * 招商详情
     */
    @Column(name = "note")
    private String note;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    @CreationTimestamp
    private Date createTime;


}

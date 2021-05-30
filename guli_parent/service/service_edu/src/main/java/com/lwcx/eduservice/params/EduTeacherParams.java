package com.lwcx.eduservice.params;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 陈翔
 */
@Data
public class EduTeacherParams {


    @ApiModelProperty(value = "讲师ID")
    private String id;

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;


    @ApiModelProperty(value = "当前页数", required = true)
    private Integer pageNum;

    @ApiModelProperty(value = "每页大小", required = true)
    private Integer pageSize;

    @ApiModelProperty(value = "开始时间")
    private String startDateTime;

    @ApiModelProperty(value = "结束时间")
    private String endDateTime;
}

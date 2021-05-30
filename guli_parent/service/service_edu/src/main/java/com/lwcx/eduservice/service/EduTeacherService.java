package com.lwcx.eduservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwcx.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lwcx.eduservice.params.EduTeacherParams;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author cx
 * @since 2021-05-30
 */
public interface EduTeacherService extends IService<EduTeacher> {

    /**
     * 按条件组合查询教师信息
     * @param eduTeacherParams
     * @return
     */
    IPage<EduTeacher> listTeacherByParams(EduTeacherParams eduTeacherParams);
}

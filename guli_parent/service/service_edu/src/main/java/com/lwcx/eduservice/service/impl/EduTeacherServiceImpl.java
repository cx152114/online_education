package com.lwcx.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lwcx.eduservice.entity.EduTeacher;
import com.lwcx.eduservice.mapper.EduTeacherMapper;
import com.lwcx.eduservice.params.EduTeacherParams;
import com.lwcx.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author cx
 * @since 2021-05-30
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Autowired
    private EduTeacherMapper eduTeacherMapper;

    @Override
    public IPage<EduTeacher> listTeacherByParams(EduTeacherParams eduTeacherParams) {
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(eduTeacherParams.getId())){
            queryWrapper.like("id", eduTeacherParams.getId());
        }
        if (!StringUtils.isEmpty(eduTeacherParams.getName())){
            queryWrapper.like("name", eduTeacherParams.getName());
        }
        if (null != eduTeacherParams.getLevel()){
            queryWrapper.eq("level", eduTeacherParams.getLevel());
        }
        if (!StringUtils.isEmpty(eduTeacherParams.getStartDateTime())){
            queryWrapper.ge("gmt_create", eduTeacherParams.getStartDateTime());
        }
        if (!StringUtils.isEmpty(eduTeacherParams.getEndDateTime())){
            queryWrapper.le("gmt_create", eduTeacherParams.getEndDateTime());
        }

        IPage<EduTeacher> page = new Page<>(eduTeacherParams.getPageNum(), eduTeacherParams.getPageSize());
        return eduTeacherMapper.selectPage(page, queryWrapper);
    }
}

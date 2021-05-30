package com.lwcx.eduservice.mapper;

import com.lwcx.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author cx
 * @since 2021-05-30
 */
@Repository
@Mapper
public interface EduTeacherMapper extends BaseMapper<EduTeacher> {

}

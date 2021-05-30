package com.lwcx.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lwcx.common.response.ResultResponse;
import com.lwcx.eduservice.entity.EduTeacher;
import com.lwcx.eduservice.params.EduTeacherParams;
import com.lwcx.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author cx
 * @since 2021-05-30
 */
@Api(value = "/eduservice/edu-teacher", description = "讲师管理")
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;


    /**
     *
     * @return
     */
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public ResultResponse findAllTeacher(){
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        List<EduTeacher> list = eduTeacherService.list(queryWrapper);
        return ResultResponse.ok().data("items", list);
    }

    @ApiOperation(value = "所有讲师列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "讲师编号",
                dataType = "string", paramType = "path", required = true),
    })
    @DeleteMapping(value = "/delete/{id}")
    public ResultResponse removeTargetTeacher(@PathVariable("id") String id){
        final boolean result = eduTeacherService.removeById(id);
        return result ? ResultResponse.ok() : ResultResponse.error();
    }

    @ApiOperation(value = "按条件分页查询教师信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页数",
                    dataType = "Integer", paramType = "path", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小",
                    dataType = "Integer", paramType = "path", required = true),
    })
    @GetMapping(value = "/page/{pageNum}/{pageSize}")
    public ResultResponse findAllTeacher(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        IPage<EduTeacher> page = new Page<>(pageNum,pageSize);
        final IPage<EduTeacher> eduTeacherIPage = eduTeacherService.page(page, queryWrapper);
        final List<EduTeacher> records = eduTeacherIPage.getRecords();
        return ResultResponse.ok().data("total", eduTeacherIPage.getTotal()).data("rows", records);
    }


    @ApiOperation(value = "按组合条件查询教师信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "eduTeacherParams", value = "查询参数",
                    dataType = "EduTeacherParams", paramType = "queryType")
    })
    @GetMapping(value = "/page")
    public ResultResponse listTeacherByParams(EduTeacherParams eduTeacherParams){
        final IPage<EduTeacher> page = eduTeacherService.listTeacherByParams(eduTeacherParams);
        return ResultResponse.ok().data("total", page.getTotal()).data("rows", page.getRecords());
    }

    @ApiOperation(value = "添加教师信息")
    @PostMapping("/addTeacher")
    public ResultResponse insertTeacher(@RequestBody EduTeacher eduTeacher) {
        final boolean result = eduTeacherService.save(eduTeacher);
        return result ? ResultResponse.ok() : ResultResponse.error();
    }

    @ApiOperation(value = "查询指定id的讲师信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "讲师编号",
                    dataType = "string", paramType = "path", required = true),
    })
    @GetMapping("/getTargetTeacher/{id}")
    public ResultResponse getTargetTeacherById(@PathVariable("id") String id){
        final EduTeacher eduTeacher = eduTeacherService.getById(id);
        return ResultResponse.ok().data("eduTeacher", eduTeacher);
    }

    @ApiOperation(value = "修改指定id的讲师信息")
    @PostMapping("/updateTargetTeacher")
    public ResultResponse updateTargetTeacherById(@RequestBody EduTeacher eduTeacher) {
        final boolean result = eduTeacherService.updateById(eduTeacher);
        return result ? ResultResponse.ok() : ResultResponse.error();

    }


}


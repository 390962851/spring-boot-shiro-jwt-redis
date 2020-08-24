package cn.github.assets.controller;

import cn.github.assets.entity.Student;
import cn.github.assets.service.StudentService;
import cn.github.util.Result;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    /*分页查询所有*/
    @RequiresPermissions("user:list")
    @RequestMapping("/findByPage/{pageNo}/{pageSize}")
    public PageInfo<Student> findByPage(@PathVariable("pageNo")int pageNo,
                                        @PathVariable("pageSize")int pageSize){
        return studentService.findByPage(pageNo,pageSize);

    }
    /*查询所有学生的学号、姓名、选课数、总成绩*/
    @RequestMapping("/selAccScore/{pageNo}/{pageSize}")
    public PageInfo<Student> selAccScore(@PathVariable("pageNo")int pageNo,
                                         @PathVariable("pageSize")int pageSize){
        return studentService.selAccScore(pageNo,pageSize);
    }

    @PostMapping("/findStuByid")
    public Result<?> findStuByid(@RequestBody Map map){
        return studentService.findStuById(map);
    }

    @PostMapping("/findPage")
    public Result<?> findPage(@RequestBody Map map){
        return studentService.findPage(map);
    }
}

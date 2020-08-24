package cn.github.assets.service.impl;

import cn.github.assets.entity.Student;
import cn.github.assets.mapper.StudentMapper;
import cn.github.assets.service.StudentService;
import cn.github.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /* *
     * @date 2020/8/18
     * @author Mr.hs
     * @params [pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo<cn.github.assets.entity.Student>
     */
    @Override
    public PageInfo<Student> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Student> list = studentMapper.findByPage();
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    /*查询所有学生的学号、姓名、选课数、总成绩*/
    @Override
    public PageInfo<Student> selAccScore(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Student> list = studentMapper.selAccScore();
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /*根据id进行查找*/
    @Override
    public Result<?> findStuById(Map map) {
        try {
            Student student = studentMapper.findStuById(map);
            return Result.ok(student);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("查询失败!");
        }
    }

    @Override
    public Result<?> findPage(Map map) {
        try {
            if (map.get("pageNo") == null || map.get("pageSize") == null) {
                return Result.error("分页参数错误!");
            } else {
                PageHelper.startPage(Integer.valueOf(map.get("pageNo").toString()),
                        Integer.valueOf(map.get("pageSize").toString()));
                List<Student> list = studentMapper.findByPage();
                PageInfo<Student> pageInfo = new PageInfo<>(list);
                return Result.ok(pageInfo);
            }
        } catch (NumberFormatException e){
            e.printStackTrace();
            return Result.error("系统异常!");
        }
    }
}

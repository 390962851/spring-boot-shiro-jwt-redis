package cn.github.assets.service;

import cn.github.assets.entity.Student;
import cn.github.util.Result;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface StudentService {

    /*分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示记录数
     * @return
     */
    PageInfo<Student> findByPage(int pageNo, int pageSize);
    /*查询所有学生的学号、姓名、选课数、总成绩*/
    PageInfo<Student> selAccScore(int pageNo, int pageSize);
    /*根据id进行查找*/
    Result<?> findStuById(Map map);
    Result<?> findPage(Map map);
}

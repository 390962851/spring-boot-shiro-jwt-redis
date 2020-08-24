package cn.github.assets.mapper;

import cn.github.assets.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper extends BaseMapper<Student> {
    /*分页查询所有*/
    List<Student> findByPage();
    /*查询所有学生的学号、姓名、选课数、总成绩*/
    List<Student> selAccScore();
    /*根据id进行查找*/
    Student findStuById(@Param("map") Map map);
}

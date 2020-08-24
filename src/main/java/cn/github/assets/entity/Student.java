package cn.github.assets.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName(value = "student")
@Data
public class Student {
    @TableId
    private int id;  //id
    private String name; //姓名
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday; //生日
    private String sex;//性别

    private int countNumber;//选课数
    private float countScore;//总成绩




}

package cn.github.visual.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName
public class Views {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;
    private Integer data;
    private String desc;
}

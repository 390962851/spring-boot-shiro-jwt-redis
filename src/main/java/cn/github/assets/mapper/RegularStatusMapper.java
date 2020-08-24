package cn.github.assets.mapper;

import cn.github.assets.entity.RegularStatus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RegularStatusMapper extends BaseMapper<RegularStatus> {

    /*获取状态列表*/
    List<RegularStatus> getAllStatus();
    /*根据id获取数据*/
    RegularStatus findById(Integer id);
    /*根据name查找*/
    RegularStatus findByName(String name);
}

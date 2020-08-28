package cn.github.visual.mapper;

import cn.github.visual.entity.Views;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @date 2020/8/26
 * @author Mr.hs
 */
public interface ViewsMapper extends BaseMapper {

    //获取访问数据
    @Select("select * from views")
    List<Views> getViews();

}

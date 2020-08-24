package cn.github.assets.mapper;

import cn.github.assets.entity.RegularAssets;
import cn.github.assets.entity.view.RegularStatusView;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegularAssetMapper extends BaseMapper {

    /*获取固定资产列表*/
    List<RegularAssets> getAllAssets();
    List<RegularStatusView> selAll(Integer current, Integer pageSize);
    int count();
    /*根据id获取数据*/
    RegularAssets findById(Integer id);
    /*根据name查找*/
    List<RegularStatusView> findByName(String name);
    /*添加单个信息*/
    Boolean addOne(RegularAssets regularAssets);
    /*根据id修改数据*/
    Boolean updateDate(RegularAssets regularAssets);
    /*根据id删除某条数据*/
    Boolean deleteById(Integer id);
}

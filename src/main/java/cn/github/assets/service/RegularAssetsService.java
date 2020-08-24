package cn.github.assets.service;


import cn.github.assets.entity.RegularAssets;
import cn.github.assets.entity.view.RegularStatusView;
import cn.github.util.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RegularAssetsService {
    /*获取固定资产列表*/
    List<RegularAssets> getAllAssets();
    Map<String,Object> selAll(Integer current, Integer pageSize);
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
    /*分页插件查找*/
    Result<?> findByPage(@Param("map") Map map);
}

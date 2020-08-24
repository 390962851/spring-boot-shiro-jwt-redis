package cn.github.assets.mapper;


import cn.github.assets.entity.InvisiableAssets;
import cn.github.assets.entity.view.InvisiableStatusView;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvisiableAssetMapper {

    List<InvisiableStatusView> selAll();

    /*分页插件查询*/
    List<InvisiableStatusView> findByPage();

    /*根据name查找*/
    List<InvisiableStatusView> findByName(String name);

    /*获取无形资产列表*/
    List<InvisiableAssets> getAllAssets();
    /*根据id获取数据*/
    InvisiableAssets findById(Integer id);
    /*添加单个信息*/
    Boolean addOne(InvisiableAssets regularAssets);
    /*根据id修改数据*/
    Boolean updateDate(InvisiableAssets regularAssets);
    /*根据id删除某条数据*/
    Boolean deleteById(Integer id);
}

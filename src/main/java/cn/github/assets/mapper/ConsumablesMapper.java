package cn.github.assets.mapper;

import cn.github.assets.entity.Consumables;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumablesMapper extends BaseMapper<Consumables> {
    /*获取易耗品列表*/
    List<Consumables> getAll();
    /*获取易耗品列表*/
    List<Consumables> findPage(@Param("current") int current, @Param("pageSize") int pageSize);

    /*分页插件实现分页查询*/
    List<Consumables> findByPage();

    int getcount();
    /*根据id获取数据*/
    Consumables findById(Integer id);
    /*根据name查找*/
    List<Consumables> findByName(String name);
    /*添加单个信息*/
    Boolean addOne(Consumables consumables);
    /*根据id修改数据*/
    Boolean updateDate(Consumables consumables);
    /*根据id删除某条数据*/
    Boolean deleteById(Integer id);
}

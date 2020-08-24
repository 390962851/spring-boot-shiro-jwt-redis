package cn.github.assets.service;

import cn.github.assets.entity.Consumables;
import com.github.pagehelper.PageInfo;

public interface ConsumablesService {
    /*分页查询*/
    PageInfo<Consumables> findByPage(int pageNo, int pageSize);
}

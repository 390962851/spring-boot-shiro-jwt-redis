package cn.github.assets.service.impl;

import cn.github.assets.entity.Consumables;
import cn.github.assets.mapper.ConsumablesMapper;
import cn.github.assets.service.ConsumablesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumablesServiceImpl implements ConsumablesService {

    @Autowired
    private ConsumablesMapper consumablesMapper;

    /*分页查询*/
    @Override
    public PageInfo<Consumables> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Consumables> list = consumablesMapper.findByPage();
        PageInfo<Consumables> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}

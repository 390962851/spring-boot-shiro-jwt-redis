package cn.github.assets.service.impl;

import cn.github.assets.entity.view.InvisiableStatusView;
import cn.github.assets.mapper.InvisiableAssetMapper;
import cn.github.assets.service.InvisiableService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvisiableServiceImp implements InvisiableService {

    @Autowired
    private InvisiableAssetMapper invisiableAssetMapper;

    /*分页查询*/
    @Override
    public PageInfo<InvisiableStatusView> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<InvisiableStatusView> list = invisiableAssetMapper.findByPage();
        PageInfo<InvisiableStatusView> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}

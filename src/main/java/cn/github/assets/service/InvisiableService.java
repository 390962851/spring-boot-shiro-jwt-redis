package cn.github.assets.service;

import cn.github.assets.entity.view.InvisiableStatusView;
import com.github.pagehelper.PageInfo;

public interface InvisiableService {
    /*分页查询*/
    PageInfo<InvisiableStatusView> findByPage(int pageNo, int pageSize);
}

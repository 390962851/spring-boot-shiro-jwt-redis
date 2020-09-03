package cn.github.user.service.Impl;

import cn.github.user.mapper.SysPermissionMapper;
import cn.github.user.service.ISysPermissionService;
import cn.github.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ISysPermissionServiceImpl implements ISysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    /*获取所有一级菜单列表*/
    @Override
    public Result getAllFirstPermission() {
        return Result.ok(sysPermissionMapper.getAllFirstPermission());
    }

    /*获取所有二级菜单列表*/
    @Override
    public Result getAllSecPermission() {
        return Result.ok(sysPermissionMapper.getAllSecPermission());
    }
}

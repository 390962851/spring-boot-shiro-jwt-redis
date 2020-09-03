package cn.github.user.service.Impl;

import cn.github.user.entity.SysUserRole;
import cn.github.user.mapper.SysUserRoleMapper;
import cn.github.user.service.ISysUserRoleService;
import cn.github.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class ISysUserRoleServiceImpl implements ISysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /*用户添加角色*/
    @Override
    public Result addUserRole(SysUserRole sysUserRole) {
        if ( sysUserRoleMapper.insert(sysUserRole) > 0 ) {
            return Result.ok("用户角色授权成功");
        } else {
            return Result.error("用户角色授权失败");
        }
    }

    /*根据id删除当前用户下的角色*/
    @Override
    public Result deleteUserRole(Map map) {
        if ( sysUserRoleMapper.deleteUserRole(map) > 0 ){
            return Result.ok("删除用户角色授权成功");
        } else {
            return Result.error("删除用户角色授权失败");
        }
    }

    /*根据用户id获取用户下角色信息*/
    @Override
    public Result getRolesByUserId(String id) {
        return Result.ok(sysUserRoleMapper.getRolesByUserId(id));
    }
}

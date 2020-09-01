package cn.github.user.service;

import cn.github.user.entity.SysUserRole;
import cn.github.util.Result;

import java.util.Map;

/*用户角色service接口*/
public interface ISysUserRoleService {

    /*用户添加角色*/
    public Result addUserRole(SysUserRole sysUserRole);

    /*根据id删除当前用户下的角色*/
    public Result deleteUserRole(Map map);

    /*根据用户id获取用户下角色信息*/
    public Result getRolesByUserId(String id);

}

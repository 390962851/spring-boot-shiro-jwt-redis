package cn.github.user.service;


import cn.github.util.Result;

/* *
 * 权限菜单服务层
 * @date 2020/9/1
 * @author Mr.hs
 * @param
 * @return
 */
public interface ISysPermissionService {

    /*获取所有一级菜单列表*/
    Result getAllFirstPermission();

    /*获取所有二级菜单*/
    Result getAllSecPermission();

}

package cn.github.user.service;

import cn.github.user.entity.SysUser;
import cn.github.user.entity.view.MenuSecV;
import cn.github.user.entity.view.MenuV;
import cn.github.util.Result;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

public interface ISysUserService extends IService<SysUser> {

    public SysUser getUserByName(String username);

    /**
     * 通过用户名获取用户角色集合
     *
     * @param username 用户名
     * @return 角色集合
     */
    Set<String> getUserRolesSet(String username);

    /**
     * 通过用户名获取用户权限集合
     *
     * @param username 用户名
     * @return 权限集合
     */
    Set<String> getUserPermissionsSet(String username);

    /**
     * 校验用户是否有效
     *
     * @param sysUser
     * @return
     */
    Result checkUserIsEffective(SysUser sysUser);

    /* *
     *根据用户名获取 用户角色下的一级菜单列表
     * @date 2020/8/21
     * @author Mr.hs
     * @params
     * @return
     */
    List<MenuV> getUserMenu(String username);

    /* *
     * 根据用户名获取子菜单列表
     * @date 2020/8/21
     * @author Mr.hs
     * @params
     * @return
     */
    List<MenuSecV> getUserMenuSecond(String username);
}

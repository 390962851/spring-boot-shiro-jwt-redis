package cn.github.user.service;

import cn.github.user.entity.SysUser;
import cn.github.user.entity.view.MenuSecV;
import cn.github.user.entity.view.MenuV;
import cn.github.util.Result;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
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

    /**
     * 分页查询所有用户
     * @date 2020/8/27
     * @author Mr.hs
     * @params
     * @return
     */
    Result<?> getAllUsers(@Param("map") Map map);

    /**
     * 根据条件查询用户
     * @date 2020/8/27
     * @author Mr.hs
     * @params
     * @return
     */
    Result<?> getUsersByCondition(@Param("map") Map map);

    /**
     * 根据id删除
     * @date 2020/8/27
     * @author Mr.hs
     * @params
     * @return
     */
    int deleteById(String id);

    /**
     * 更新数据
     * @date 2020/8/28
     * @author Mr.hs
     * @params
     * @return
     */
    int updateUser(SysUser sysUser);

    /**
     * 添加用户
     * @date 2020/8/28
     * @author Mr.hs
     * @params [sysUser]
     * @return cn.github.util.Result
     */
    Result addUser(SysUser sysUser);


}

package cn.github.user.service.Impl;

import cn.github.constant.CommonConstant;
import cn.github.user.entity.SysPermission;
import cn.github.user.entity.SysUser;
import cn.github.user.entity.view.MenuSecV;
import cn.github.user.entity.view.MenuV;
import cn.github.user.mapper.SysPermissionMapper;
import cn.github.user.mapper.SysUserMapper;
import cn.github.user.mapper.SysUserRoleMapper;
import cn.github.user.service.ISysUserService;
import cn.github.util.CommonUtils;
import cn.github.util.Result;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 用户表 服务实现类
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public SysUser getUserByName(String username) {
        return userMapper.getUserByName(username);
    }


    /**
     * 通过用户名获取用户角色集合
     * @param username 用户名
     * @return 角色集合
     */
    @Override
    @Cacheable(value = CommonConstant.LOGIN_USER_RULES_CACHE, key = "'Roles_'+#username")
    public Set<String> getUserRolesSet(String username) {
        // 查询用户拥有的角色集合
        List<String> roles = sysUserRoleMapper.getRoleByUserName(username);
        log.info("-------通过数据库读取用户拥有的角色Rules------username： " + username + ",Roles size: " + (roles == null ? 0 : roles.size()));
        return new HashSet<>(roles);
    }

    /**
     * 通过用户名获取用户权限集合
     *
     * @param username 用户名
     * @return 权限集合
     */
    @Override
    @Cacheable(value = CommonConstant.LOGIN_USER_RULES_CACHE, key = "'Permissions_'+#username")
    public Set<String> getUserPermissionsSet(String username) {
        Set<String> permissionSet = new HashSet<>();
        List<SysPermission> permissionList = sysPermissionMapper.queryByUser(username);
        for (SysPermission po : permissionList) {
            if (CommonUtils.isNotEmpty(po.getPerms())) {
                permissionSet.add(po.getPerms());
            }
        }
        log.info("-------通过数据库读取用户拥有的权限Perms------username： " + username + ",Perms size: " + (permissionSet == null ? 0 : permissionSet.size()));
        return permissionSet;
    }

    /**
     * 校验用户是否有效
     *
     * @param sysUser
     * @return
     */
    @Override
    public Result<?> checkUserIsEffective(SysUser sysUser) {
        Result<?> result = new Result<Object>();
        //情况1：根据用户信息查询，该用户不存在
        if (sysUser == null) {
            result.error500("该用户不存在，请注册");
            return result;
        }
        //情况2：根据用户信息查询，该用户已注销
        if (CommonConstant.DEL_FLAG_1.toString().equals(sysUser.getDelFlag())) {
            result.error500("该用户已注销");
            return result;
        }
        //情况3：根据用户信息查询，该用户已被删除
        if (CommonConstant.USER_FREEZE.equals(sysUser.getDelFlag())) {
            result.error500("该用户已被删除");
            return result;
        }
        return result;
    }

    /* *
     *根据用户名获取 用户角色下的一级菜单列表
     * @date 2020/8/21
     * @author Mr.hs
     * @params
     * @return
     */
    @Override
    public List<MenuV> getUserMenu(String username) {
        return sysPermissionMapper.getUserMenu(username);
    }

    /* *
     * 根据用户名获取子菜单列表
     * @date 2020/8/21
     * @author Mr.hs
     * @params
     * @return
     */
    @Override
    public List<MenuSecV> getUserMenuSecond(String username) {
        return sysPermissionMapper.getUserMenuSecond(username);
    }

    /**
     * 分页查询所有用户
     * @date 2020/8/27
     * @author Mr.hs
     * @params
     * @return
     */
    @Override
    public Result<?> getAllUsers(Map map) {
        try {
            if (map.get("pageNo") == null || map.get("pageSize") == null) {
                return Result.error("分页参数错误!");
            } else {
                PageHelper.startPage(Integer.valueOf(map.get("pageNo").toString()),Integer.valueOf(map.get("pageSize").toString()));
                List<SysUser> list = userMapper.getAllUsers(map);
                PageInfo<SysUser> pageInfo = new PageInfo<>(list);
                return Result.ok(pageInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("查询出错!");
        }
    }

    /**
     * 根据条件查询用户
     * @date 2020/8/27
     * @author Mr.hs
     * @params [map]
     * @return cn.github.util.Result<?>
     */
    @Override
    public Result<?> getUsersByCondition(Map map) {
        return null;
    }

    /**
     * 根据id删除用户
     * @date 2020/8/27
     * @author Mr.hs
     * @params [id]
     * @return cn.github.util.Result<?>
     */
    @Override
    public int deleteById(String id) {
        return userMapper.deleteById(id);
    }

    /**
     * 更新数据
     * @date 2020/8/28
     * @author Mr.hs
     * @params
     * @return
     */
    @Override
    public int updateUser(SysUser sysUser) {
        return userMapper.updateById(sysUser);
    }

    /**
     * 添加用户
     * @date 2020/8/28
     * @author Mr.hs
     * @params [sysUser]
     * @return int
     */
    @Override
    public Result addUser(SysUser sysUser) {
        if ( this.save(sysUser) ) {
            return Result.ok("添加成功");
        } else {
            return Result.error("添加失败");
        }
    }
}

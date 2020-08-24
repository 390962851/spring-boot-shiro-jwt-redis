package cn.github.user.mapper;

import cn.github.user.entity.SysPermission;
import cn.github.user.entity.view.MenuSecV;
import cn.github.user.entity.view.MenuV;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单权限表 Mapper 接口
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 根据用户查询用户权限
     */
    public List<SysPermission> queryByUser(@Param("username") String username);

    /**
     * 根据用户查询用户权限下所拥有的菜单
     */
    public List<MenuV> getUserMenu(String username);

    /**
     * 根据用户名查询子菜单
     */
    public List<MenuSecV> getUserMenuSecond(String username);

}

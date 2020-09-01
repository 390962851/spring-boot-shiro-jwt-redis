package cn.github.user.mapper;

import cn.github.user.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 角色列表mapper接口
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 获取所有 分页
     * @param map
     * @return
     */
    List<SysRole> getAllRoles(@Param("map")Map map);

    /*获取所有*/
    List<SysRole> findAllRoles();
}

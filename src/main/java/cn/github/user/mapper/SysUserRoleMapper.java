package cn.github.user.mapper;

import cn.github.user.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户角色表 Mapper 接口
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /*根据用户名获取用户角色id*/
//    @Select("select id from sys_role where id in (select role_id from sys_user_role where user_id = (select id from sys_user where user_name=#{username}))")
    List<String> getRoleByUserName(@Param("username") String username);

    /*根据用户id获取当前用户下拥有的角色*/
    List<String> getRolesByUserId(@Param("id") String id);

    /*删除一条信息*/
    int deleteUserRole(@Param("map") Map map);
}

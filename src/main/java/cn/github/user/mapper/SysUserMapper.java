package cn.github.user.mapper;

import cn.github.user.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户表 Mapper 接口
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 通过用户账号查询用户信息
     *
     * @param username
     * @return
     */
    public SysUser getUserByName(@Param("username") String username);

    //分页查询所有用户
    List<SysUser> getAllUsers(@Param("map") Map map);

    //编辑用户信息
    //添加用户
    //删除用户

}

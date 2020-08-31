package cn.github.user.service;

import cn.github.user.entity.SysRole;
import cn.github.util.Result;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 角色列表 service 服务类
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * 获取所有信息
     * @date 2020/8/29
     * @author Mr.hs
     * @param map
     * @return cn.github.util.Result
     */
    public Result getAllRoles(Map map);

    /*根据id删除*/
    public Result deleteById(String id);

    /*添加信息*/
    public Result addRoles(SysRole sysRole);

    /*更新数据  根据id*/
    public Result updateRole(SysRole sysRole);
}

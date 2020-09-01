package cn.github.user.controller;


import cn.github.user.entity.SysUserRole;
import cn.github.user.service.ISysUserRoleService;
import cn.github.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Autowired
    private ISysUserRoleService sysUserRoleService;

    /*用户添加角色*/
    @PostMapping("/addUserRole")
    public Result addUserRole(@RequestBody SysUserRole sysUserRole){
        return sysUserRoleService.addUserRole(sysUserRole);
    }

    /**
     * 根据id删除当前用户下的角色
     * @date 2020/8/31
     * @author Mr.hs
     * @param map
     * @return cn.github.util.Result
     */
    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestBody Map map){
        return sysUserRoleService.deleteUserRole(map);
    }

    /*根据用户id获取用户下角色信息*/
    @PostMapping("/getRolesByUserId/{id}")
    public Result getRolesByUserId(@PathVariable("id") String id){
        return sysUserRoleService.getRolesByUserId(id);
    }



}

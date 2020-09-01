package cn.github.user.controller;

import cn.github.user.entity.SysRole;
import cn.github.user.service.ISysRoleService;
import cn.github.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private ISysRoleService sysRoleService;

    /**
     * 获取所有角色信息 分页
     * @date 2020/8/29
     * @author Mr.hs
     * @param map
     * @return cn.github.util.Result<?>
     */
    @PostMapping("/getAllRoles")
    public Result<?> getAllRoles(@RequestBody Map map){
        return sysRoleService.getAllRoles(map);
    }

    /*获取所有角色信息*/
    @GetMapping("/findAllRoles")
    public Result<?> findAllRoles(){
        return Result.ok(sysRoleService.findAllRoles());
    }

    /* *
     * 根据id删除
     * @date 2020/8/29
     * @author Mr.hs
     * @param
     * @return
     */
    @DeleteMapping("/deleteById/{id}")
    public Result<?> deleteById(@PathVariable("id") String id){
        return sysRoleService.deleteById(id);
    }

    /* *
     * 添加一条信息
     * @date 2020/8/29
     * @author Mr.hs
     * @param [sysRole]
     * @return cn.github.util.Result<?>
     */
    @PostMapping("/addRole")
    public Result<?> addRole(@RequestBody SysRole sysRole){
        return sysRoleService.addRoles(sysRole);
    }

    /* *
     * 根据id修改数据
     * @date 2020/8/29
     * @author Mr.hs
     * @param [sysRole]
     * @return cn.github.util.Result<?>
     */
    @PutMapping("/updateById")
    public Result<?> updateById(@RequestBody SysRole sysRole){
        return sysRoleService.updateRole(sysRole);
    }
}

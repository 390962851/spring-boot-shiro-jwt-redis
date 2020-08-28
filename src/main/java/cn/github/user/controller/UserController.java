package cn.github.user.controller;

import cn.github.user.entity.SysUser;
import cn.github.user.service.ISysUserService;
import cn.github.util.CommonUtils;
import cn.github.util.PasswordUtil;
import cn.github.util.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ISysUserService iSysUserService;

    @RequiresPermissions("user:add")
    @PostMapping("/addUser")
    public Result userAdd(@RequestBody SysUser sysUser) {
        try {
            String salt = CommonUtils.randomGen(8);
            String passwordEncode  = PasswordUtil.encrypt(sysUser.getUserName(),sysUser.getPassWord(),salt);
            sysUser.setSalt(salt);
            sysUser.setPassWord(passwordEncode);
            return iSysUserService.addUser(sysUser);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(500,"操作失败");
        }
    }

    @RequiresPermissions("user:delete")
    @DeleteMapping("/userDelete/{id}")
    public Result userDelete(@PathVariable("id") String id) {
        if (iSysUserService.deleteById(id) > 0){
            return Result.ok("删除用户");
        } else {
            return Result.error("删除失败");
        }
    }

    @RequiresPermissions("user:update")
    @PostMapping("/userUpdate")
    public Result userUpdate(@RequestBody SysUser sysUser) {

        System.out.println("sysUser ======== " + sysUser.toString());
        if (iSysUserService.updateUser(sysUser) > 0) {
            return Result.ok("修改成功");
        } else {
            return Result.error("修改失败");
        }
    }

    @PostMapping("/getAllUsers")
    public Result getAllUsers(@RequestBody Map map){
        return iSysUserService.getAllUsers(map);
    }

    @RequestMapping("test")
    public Result test() {
        return Result.ok("不用登陆直接访问的接口");
    }

}

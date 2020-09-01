package cn.github.user.service.impl;

import cn.github.user.entity.SysRole;
import cn.github.user.mapper.SysRoleMapper;
import cn.github.user.service.ISysRoleService;
import cn.github.util.CommonUtils;
import cn.github.util.Result;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ISysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 获取所有信息
     * @param map
     * @return
     */
    @Override
    public Result getAllRoles(Map map) {
        try {
            if (CommonUtils.isEmpty(map.get("pageNo")) || CommonUtils.isEmpty(map.get("pageSize"))) {
                return Result.error("分页参数错误!");
            } else {
                PageHelper.startPage(Integer.valueOf(map.get("pageNo").toString()), Integer.valueOf(map.get("pageSize").toString()));
                List<SysRole> list = sysRoleMapper.getAllRoles(map);
                PageInfo<SysRole> pageInfo = new PageInfo<>(list);
                return Result.ok(pageInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("系统出错!");
        }
    }

    /*获取所有*/
    @Override
    public List<SysRole> findAllRoles() {
        return sysRoleMapper.findAllRoles();
    }

    /**
     * 根据id删除
     * @date 2020/8/29
     * @author Mr.hs
     * @param id
     * @return cn.github.util.Result
     */
    @Override
    public Result deleteById(String id) {
        if (sysRoleMapper.deleteById(id) > 0)
            return Result.ok("删除成功!");
        else
            return Result.error("删除失败");
    }

    /**
     * 添加一条信息
     * @param sysRole
     * @return
     */
    @Override
    public Result addRoles(SysRole sysRole) {
        if (this.save(sysRole)) {
            return Result.ok("添加成功!");
        } else {
            return Result.error("添加失败!");
        }
    }

    /**
     * 更新一条信息
     * @param sysRole
     * @return
     */
    @Override
    public Result updateRole(SysRole sysRole) {
        if (sysRoleMapper.updateById(sysRole) > 0) {
            return Result.ok("更新成功!");
        } else {
            return Result.error("更新失败!");
        }
    }
}

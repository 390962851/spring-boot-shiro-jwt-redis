package cn.github.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 菜单权限表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 路径
     */
    private String url;

    /**
     * 组件-路由
     */
    private String component;

    /**
     * 组件名称
     */
    private String componentName;

    /**
     * 类型（0：一级菜单；1：子菜单 ；2：按钮权限）
     */
    private Integer menuType;

    /**
     * 菜单权限编码，例如：“sys:schedule:list,sys:schedule:info”,多个逗号隔开
     */
    private String perms;

    /**
     * 权限策略（1：显示，2：禁用）
     */
    private String permsType;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 是否路由菜单: 0:不是  1:是（默认值1）
     */
    private Integer isRoute;

    /**
     * 是否叶子节点:    1:是   0:不是
     */
    private Integer isLeaf;

    /**
     * 菜单排序
     */
    private Integer sortNo;

    /**
     * 删除状态 0正常 1已删除
     */
    private Integer delFlag;

}

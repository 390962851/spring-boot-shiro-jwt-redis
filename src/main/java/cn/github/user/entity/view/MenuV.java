package cn.github.user.entity.view;

import lombok.Data;

import java.util.List;

/* *
 * 导航栏一级菜单列表展示
 * @date 2020/8/21
 * @author Mr.hs
 * @params
 * @return
 */
@Data
public class MenuV {
    private static final long serialVersionUID = 1L;

    private String id;
    private String parentId;
    private String name;
    private String url;
    private String perms;
    private String icon;
    private Integer sortNo;
    /**
     * 是否叶子节点:    1:是   0:不是
     */
    private Integer isLeaf;

    private Integer delFlag;
    List<MenuSecV> children; //二级导航栏
}

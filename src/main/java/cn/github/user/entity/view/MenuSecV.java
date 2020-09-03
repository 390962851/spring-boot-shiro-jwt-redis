package cn.github.user.entity.view;

import lombok.Data;

/* *
 * 导航栏二级菜单列表展示
 * @date 2020/8/21
 * @author Mr.hs
 * @params
 * @return
 */
@Data
public class MenuSecV {
    private static final long serialVersionUID = 1L;

    private String id;
    private String parentId;
    private String name;
    private String component;
    private String url;
    private String perms;
    private Integer sortNo;
    private String icon;
    /**
     * 是否叶子节点:    1:是   0:不是
     */
    private Integer isLeaf;
    private Integer delFlag; //是否删除
}

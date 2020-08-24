package cn.github.user.entity.view;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

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
    private String componentName;
//    private String component;
    private String component;
    private String icon;
    private List<T> rights;
}

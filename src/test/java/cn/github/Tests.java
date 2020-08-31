package cn.github;

import cn.github.user.entity.view.MenuSecV;
import cn.github.user.entity.view.MenuV;
import cn.github.user.mapper.SysRoleMapper;
import cn.github.user.service.ISysRoleService;
import cn.github.user.service.ISysUserService;
import cn.github.visual.mapper.ViewsMapper;
import cn.github.visual.service.ViewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {
    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private ViewsMapper viewsMapper;
    @Autowired
    private ViewsService viewService;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private ISysRoleService sysRoleService;

    @Test
    public void aa(){
        String username = "admin";
        List<MenuV> vList = iSysUserService.getUserMenu(username);
        List<MenuSecV> secVListK = iSysUserService.getUserMenuSecond(username);
        for (MenuV menuV : vList) {
            List<MenuSecV> aa = new ArrayList<MenuSecV>();
            for (MenuSecV menuSecV : secVListK) {
                if (menuV.getId().equals(menuSecV.getParentId())){
                    aa.add(menuSecV);
                }
            }
            menuV.setChildren(aa);
        }
        System.out.println("vList = " + vList + '\t');
    }

    @Test
    public void bb(){
        System.out.println("iSysUserService.getUserMenuSecond(\"admin\") = " + iSysUserService.getUserMenuSecond("admin"));
    }

    @Test
    public void cc(){
        System.out.println("viewService.getViews() = " + viewService.getViews());
    }

    @Test
    public void dd(){
        Map<String,Integer> map = new HashMap();
        map.put("pageNo",1);
        map.put("pageSize",5);
        System.out.println("iSysUserService.getAllUsers(map) = " + iSysUserService.getAllUsers(map));
    }

    @Test
    public void ee(){
        Map<String,String> map = new HashMap();
        map.put("pageNo","1");
        map.put("pageSize","5");
//        map.put("roleName", "d");
        System.out.println("*******= ");
    }
}

package cn.github;

import cn.github.user.entity.view.MenuSecV;
import cn.github.user.entity.view.MenuV;
import cn.github.user.service.ISysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {
    @Autowired
    private ISysUserService iSysUserService;

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
}

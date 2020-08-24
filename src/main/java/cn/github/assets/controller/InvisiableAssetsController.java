package cn.github.assets.controller;

import cn.github.assets.entity.InvisiableAssets;
import cn.github.assets.entity.RegularStatus;
import cn.github.assets.entity.view.InvisiableStatusView;
import cn.github.assets.mapper.InvisiableAssetMapper;
import cn.github.assets.service.InvisiableService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/invisiable")
public class InvisiableAssetsController {

    @Autowired
    InvisiableAssetMapper invisiableAssetMapper;
    @Autowired
    private InvisiableService invisiableService;

    /*获取所有*/
    @GetMapping("/getAllAssets")
    public List<InvisiableAssets> getAll() {
//        System.out.println(regularAssetDao.getAllAssets());
        return invisiableAssetMapper.getAllAssets();
    }
    /*根据name查找*/
    @GetMapping("/findByName/{name}")
    public List<InvisiableStatusView> findByName(@PathVariable("name") String name){
        List<InvisiableStatusView> list = invisiableAssetMapper.findByName(name);
        System.out.println(list);
        try {
            for (InvisiableStatusView r : list) {
                RegularStatus regularStatus = r.getRegular_status();
                regularStatus.setDateTime(r.getStatusDate());
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    /*分页插件实现查询*/
    @GetMapping("/findByPage/{current}/{pageSize}")
    public PageInfo<InvisiableStatusView> findByPage(@PathVariable("current")int current, @PathVariable("pageSize")int pageSize){
        return invisiableService.findByPage(current,pageSize);
    }


    @GetMapping("/selAll")
    public List<InvisiableStatusView> selAll() {
        List<InvisiableStatusView> list = invisiableAssetMapper.selAll();
        for (InvisiableStatusView u : list) {
            RegularStatus statusList = u.getRegular_status();
            statusList.setDateTime(u.getStatusDate());
//            System.out.println(statusList);
        }
        return list;
    }

    /*根据id查找*/
    @GetMapping("/findById/{id}")
    public InvisiableAssets findById(@PathVariable("id") Integer id) {
        InvisiableAssets regularAssets = invisiableAssetMapper.findById(id);
        if (Objects.isNull(regularAssets)) {
            return null;
        }
        return regularAssets;
    }

    //    /*添加信息*/
    @PostMapping("add")
    public boolean add(@RequestBody InvisiableAssets invisiableAssets) {
//        regularAssetDao.addOne(regularAssets);
        System.out.println("add==" + invisiableAssets);
//        if (Objects.isNull())
        return invisiableAssetMapper.addOne(invisiableAssets);
    }

    /*根据id修改数据*/
    @PostMapping("update")
    public boolean update(@RequestBody InvisiableAssets invisiableAssets) {
        System.out.println("update==" + invisiableAssets);
        try {
            boolean b = invisiableAssetMapper.updateDate(invisiableAssets);
            return b;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /*根据id删除某条数据*/
    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable("id") Integer id) {
        return invisiableAssetMapper.deleteById(id);
    }

}

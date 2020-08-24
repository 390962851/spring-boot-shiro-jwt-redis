package cn.github.assets.controller;


import cn.github.assets.entity.RegularAssets;
import cn.github.assets.entity.view.RegularStatusView;
import cn.github.assets.service.RegularAssetsService;
import cn.github.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/assets")
public class RegularAssetsController {

    @Autowired
    private RegularAssetsService regularAssetsService;

    /*获取所有*/
    @GetMapping("/getAllAssets")
    public List<RegularAssets> getAll() {
//        System.out.println(regularAssetDao.getAllAssets());
        return regularAssetsService.getAllAssets();
    }

    /*根据name查找*/
    @GetMapping("/findByName/{name}")
    public List<RegularStatusView> findByName(@PathVariable("name") String name) {
        return regularAssetsService.findByName(name);
    }

    @GetMapping("/selAll/{current}/{pageSize}")
    public Map<String, Object> selAll(@PathVariable("current") Integer current,
                                      @PathVariable("pageSize") Integer pageSize) {
        return regularAssetsService.selAll(current,pageSize);
    }

    /*根据id查找*/
    @GetMapping("/findById/{id}")
    public RegularAssets findById(@PathVariable("id") Integer id) {
        RegularAssets regularAssets = regularAssetsService.findById(id);
        if (Objects.isNull(regularAssets)) {
            return null;
        }
        return regularAssets;
    }

    //    /*添加信息*/
    @PostMapping("add")
    public boolean add(@RequestBody RegularAssets regularAssets) {
        return regularAssetsService.addOne(regularAssets);
    }

    /*根据id修改数据*/
    @PutMapping("update")
    public boolean update(@RequestBody RegularAssets regularAssets) {
        return regularAssetsService.updateDate(regularAssets);
    }

    /*根据id删除某条数据*/
    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable("id") Integer id) {
        return regularAssetsService.deleteById(id);
    }
    /* *
     * @date 2020/8/18
     * @author Mr.hs
     * @params
     * @return
     */
    @PostMapping("/findByPage")
    public Result<?> findByPage(@RequestBody Map map){
        return regularAssetsService.findByPage(map);
    }

}

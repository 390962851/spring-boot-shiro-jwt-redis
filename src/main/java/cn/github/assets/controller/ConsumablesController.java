package cn.github.assets.controller;

import cn.github.assets.entity.Consumables;
import cn.github.assets.mapper.ConsumablesMapper;
import cn.github.assets.service.ConsumablesService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/consumables")
public class ConsumablesController {

    @Autowired
    ConsumablesMapper consumablesMapper;
    @Autowired
    private ConsumablesService consumablesService;

    /*获取所有*/
    @GetMapping("/getAll")
    public List<Consumables> getAll() {
        return consumablesMapper.getAll();
    }

    /*分页插件分页查询*/
    @GetMapping("/findByPage/{current}/{pageSize}")
    public PageInfo<Consumables> findByPage(@PathVariable("current")int current, @PathVariable("pageSize")int pageSize){
        return consumablesService.findByPage(current,pageSize);
    }

    /*获取所有普通分页查询*/
    @GetMapping("/findPage/{current}/{pageSize}")
    public Map<String, Object> findPage(@PathVariable("current")int current, @PathVariable("pageSize")int pageSize) {
        int total = consumablesMapper.getcount();
        int startRow = (current - 1) * pageSize;
        List<Consumables> list = consumablesMapper.findPage(startRow, pageSize);
        System.out.println(list);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("list",list);
        return map;
    }
    /*根据name查找*/
    @GetMapping("/findByName/{name}")
    public List<Consumables> findByName(@PathVariable("name") String name){
        try {
            List<Consumables> list = consumablesMapper.findByName(name);
            System.out.println(list);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /*根据id查找*/
    @GetMapping("/findById/{id}")
    public Consumables findById(@PathVariable("id") Integer id) {
        Consumables consumables = consumablesMapper.findById(id);
        if (Objects.isNull(consumables)) {
            return null;
        }
        return consumables;
    }
    /*添加信息*/
    @PostMapping("add")
    public boolean add(@RequestBody Consumables consumables) {
        System.out.println("add==" + consumables);
        return consumablesMapper.addOne(consumables);
    }

    /*根据id修改数据*/
    @PostMapping("update")
    public boolean update(@RequestBody Consumables consumables) {
        return consumablesMapper.updateDate(consumables);
    }

    /*根据id删除某条数据*/
    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable("id") Integer id) {
        return consumablesMapper.deleteById(id);
    }

}

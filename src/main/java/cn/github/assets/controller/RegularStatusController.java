package cn.github.assets.controller;


import cn.github.assets.entity.RegularStatus;
import cn.github.assets.mapper.RegularStatusMapper;
import cn.github.assets.service.RegularStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
public class RegularStatusController {

    @Autowired
    private RegularStatusService regularStatusService;

    @GetMapping("/findById/{id}")
    public RegularStatus findById(@PathVariable("id") Integer id){
        return regularStatusService.findById(id);
    }

    @GetMapping("/getAllStatus")
    public List<RegularStatus> getAllStatus(){
        return regularStatusService.getAllStatus();
    }

    @GetMapping("/findByName/{name}")
    public RegularStatus findByName(@PathVariable("name") String name){
        return regularStatusService.findByName(name);
    }

}

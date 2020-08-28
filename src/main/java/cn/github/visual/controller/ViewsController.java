package cn.github.visual.controller;

import cn.github.util.Result;
import cn.github.visual.service.ViewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 可视化数据
 * @date 2020/8/27
 * @author Mr.hs
 */
@RestController
@RequestMapping("/visual")
@Slf4j
public class ViewsController {
    @Autowired
    private ViewsService viewsService;

    /**
     * 查询访问人数
     * @date 2020/8/27
     * @author Mr.hs
     * @params []
     * @return cn.github.util.Result<?>
     */
    @GetMapping("/views")
    public Result<?> getViews(){
        return viewsService.getViews();
    }
}

package cn.github.visual.service.impl;

import cn.github.util.CommonUtils;
import cn.github.util.Result;
import cn.github.visual.entity.Views;
import cn.github.visual.mapper.ViewsMapper;
import cn.github.visual.service.ViewsService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewsServiceImpl implements ViewsService {

    @Autowired
    private ViewsMapper viewsMapper;
    /* *
     *获取访问数据
     * @date 2020/8/26
     * @author Mr.hs
     * @params []
     * @return cn.github.util.Result<?>
     */
    @Override
    public Result<?> getViews() {
        Result<JSONObject> result = new Result<>();
        List<Views> list = viewsMapper.getViews();
        JSONObject object = new JSONObject();
        List<String> xAxis = new ArrayList<>();
        List<Integer> seriesD = new ArrayList<>();
        for (Views views : list) {
            if (CommonUtils.isNotEmpty(views)){
                xAxis.add(views.getName());
                seriesD.add(views.getData());
            }
        }
        object.put("name", "访问人数");
        object.put("xAxis", xAxis);
        object.put("seriesD", seriesD);
        result.setResult(object);
        result.success("查询成功");
        return result;
    }
}

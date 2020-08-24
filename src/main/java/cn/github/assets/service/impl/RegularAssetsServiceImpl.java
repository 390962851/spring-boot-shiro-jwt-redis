package cn.github.assets.service.impl;

import cn.github.assets.entity.RegularAssets;
import cn.github.assets.entity.RegularStatus;
import cn.github.assets.entity.view.RegularStatusView;
import cn.github.assets.mapper.RegularAssetMapper;
import cn.github.assets.service.RegularAssetsService;
import cn.github.util.CommonUtils;
import cn.github.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegularAssetsServiceImpl implements RegularAssetsService {

    @Autowired
    private RegularAssetMapper regularAssetMapper;

    @Override
    public List<RegularAssets> getAllAssets() {
        return regularAssetMapper.getAllAssets();
    }

    /**
     * @param current
     * @param pageSize
     * @return
     */
    @Override
    public Map<String,Object> selAll(Integer current, Integer pageSize) {
        int startRow = (current - 1) * pageSize;
        List<RegularStatusView> list = regularAssetMapper.selAll(startRow, pageSize);
        int count = regularAssetMapper.count();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("count",count);
        for (RegularStatusView u : list) {
            RegularStatus statusList = u.getRegular_status();
            statusList.setDateTime(u.getStatusDate());
        }
        map.put("list",list);
        return map;
    }

    /*根据id获取数据*/
    @Override
    public RegularAssets findById(Integer id) {
        return regularAssetMapper.findById(id);
    }

    @Override
    public List<RegularStatusView> findByName(String name) {
        List<RegularStatusView> list = regularAssetMapper.findByName(name);
//        System.out.println(list);
        for (RegularStatusView r : list) {
            RegularStatus regularStatus = r.getRegular_status();
            regularStatus.setDateTime(r.getStatusDate());
        }
        return list;
    }

    @Override
    public Boolean addOne(RegularAssets regularAssets) {
        return regularAssetMapper.addOne(regularAssets);
    }

    @Override
    public Boolean updateDate(RegularAssets regularAssets) {
        return regularAssetMapper.updateDate(regularAssets);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return regularAssetMapper.deleteById(id);
    }

    /* *
     * @date 2020/8/18
     * @author Mr.hs
     * @params [map]
     * @return cn.github.util.Result<?>
     */
    @Override
    public Result<?> findByPage(Map map) {
        try {
            if (CommonUtils.isEmpty(map.get("pageNo").toString()) ||
                    CommonUtils.isEmpty(map.get("pageSize").toString())) {
                return Result.error("分页参数错误！");
            } else {
                PageHelper.startPage(Integer.valueOf(map.get("pageNo").toString()),
                        Integer.valueOf(map.get("pageSize").toString()));
                List<RegularAssets> list = regularAssetMapper.getAllAssets();
                PageInfo<RegularAssets> pageInfo = new PageInfo<>(list);
                return Result.ok(pageInfo);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return Result.error("分页查询出错！");
        }
    }
}

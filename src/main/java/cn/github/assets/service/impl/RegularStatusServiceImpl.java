package cn.github.assets.service.impl;

import cn.github.assets.entity.RegularStatus;
import cn.github.assets.mapper.RegularStatusMapper;
import cn.github.assets.service.RegularStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegularStatusServiceImpl implements RegularStatusService {
    @Autowired
    private RegularStatusMapper regularStatusMapper;
    /* *
     * @date 2020/8/18
     * @author Mr.hs
     * @params []
     * @return java.util.List<cn.github.assets.entity.RegularStatus>
     */
    @Override
    public List<RegularStatus> getAllStatus() {
        List<RegularStatus> list = regularStatusMapper.getAllStatus();
        return list;
    }

    @Override
    public RegularStatus findById(Integer id) {
        return regularStatusMapper.findById(id);
    }

    @Override
    public RegularStatus findByName(String name) {
        return regularStatusMapper.findByName(name);
    }
}

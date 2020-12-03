package com.glyxybxhtxt.service.impl;

import com.glyxybxhtxt.dao.HcMapper;
import com.glyxybxhtxt.dataObject.Hc;
import com.glyxybxhtxt.service.HcService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author:wangzh
 * Date: 2020/12/3 21:07
 * Version: 1.0
 */
@Service
public class HcServiceImpl implements HcService {
    @Resource
    private HcMapper hcMapper;

    @Override
    public List<Hc> selall() {
        return hcMapper.selall();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delhc(int id) {
        return hcMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int newhc(Hc h) {
        return hcMapper.insert(h);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int uphc(Hc h) {
        return hcMapper.updateByPrimaryKeySelective(h);
    }
}

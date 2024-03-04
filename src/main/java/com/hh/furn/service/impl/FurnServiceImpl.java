package com.hh.furn.service.impl;

import com.hh.furn.bean.Furn;
import com.hh.furn.bean.FurnExample;
import com.hh.furn.dao.FurnMapper;
import com.hh.furn.service.FurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 黄昊
 * @version 1.0
 **/
@Service
public class FurnServiceImpl implements FurnService {
    @Resource
    private FurnMapper furnMapper;
    @Override
    public int save(Furn furn) {
        int i = furnMapper.insertSelective(furn);
        return i;
    }

    @Override
    public List<Furn> findAll() {
      return    furnMapper.selectByExample(null);
    }

    @Override
    public void update(Furn furn) {
        furnMapper.updateByPrimaryKeySelective(furn);
    }

    @Override
    public Furn findById(int id) {
        Furn furn = furnMapper.selectByPrimaryKey(id);
        return furn;
    }

    @Override
    public void delete(int id) {
        furnMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Furn> findByCondition(String name) {
        FurnExample furnExample = new FurnExample();
        FurnExample.Criteria criteria = furnExample.createCriteria();
        if (StringUtils.hasText(name)){
            criteria.andNameLike("%"+name+"%");
        }
        return furnMapper.selectByExample(furnExample);
    }
}

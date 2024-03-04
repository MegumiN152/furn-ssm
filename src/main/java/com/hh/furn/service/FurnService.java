package com.hh.furn.service;

import com.hh.furn.bean.Furn;

import java.util.List;

/**
 * @author 黄昊
 * @version 1.0
 **/
public interface FurnService {
    public int save(Furn furn);
    public List<Furn> findAll();
    public void update(Furn furn);

    public Furn findById(int id);

    public void delete(int id);
    public List<Furn> findByCondition(String name);
}

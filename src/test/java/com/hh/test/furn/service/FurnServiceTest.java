package com.hh.test.furn.service;

import com.hh.furn.bean.Furn;
import com.hh.furn.service.FurnService;
import com.hh.furn.service.impl.FurnServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 黄昊
 * @version 1.0
 **/
public class FurnServiceTest {
    private FurnService furnService;
    private ApplicationContext ioc;

    @Before
    public void init() {
        ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        furnService = ioc.getBean(FurnService.class);
    }

    @Test
    public void T1() {
        Furn furn = new Furn(null, "美式骚货", "三次元", new BigDecimal(12310), 110, 120, "assets/images/product-image/1.jpg");
        int i = furnService.save(furn);
        System.out.println(i);
    }
    @Test
    public void findAll(){
        List<Furn> all = furnService.findAll();
        for (Furn furn : all) {
            System.out.println(furn);
        }
    }
    @Test
    public void update(){
        Furn furn = new Furn();
        furn.setId(1);
        furn.setName("王者荣耀");
        furn.setMaker("腾讯");
        furnService.update(furn);
    }
    @Test
    public void findByCondtion(){
        List<Furn> condition = furnService.findByCondition("式");
        for (Furn furn : condition) {
            System.out.println(furn);
        }
    }
}

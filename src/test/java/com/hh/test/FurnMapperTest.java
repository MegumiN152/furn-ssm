package com.hh.test;

import com.hh.furn.bean.Furn;
import com.hh.furn.dao.FurnMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * @author 黄昊
 * @version 1.0
 **/
public class FurnMapperTest {
    @Test
    public void FurnMapperTest1(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
//        System.out.println(furnMapper.getClass());
        Furn furn = new Furn(null, "日式骚货", "二次元", new BigDecimal(10010), 1100, 10, "assets/images/product-image/1.jpg");
        int i = furnMapper.insertSelective(furn);
        System.out.println(i);
    }
    @Test
    public void FurnMapperTest2(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        int i = furnMapper.deleteByPrimaryKey(6);
        System.out.println("affected="+i);
        System.out.println("成功");
    }

    @Test
    public void FurnMapperTest3(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        Furn furn = new Furn();
        furn.setId(1);
        furn.setName("狼与香辛料");
        int i = furnMapper.updateByPrimaryKeySelective(furn);
        System.out.println(i);
    }
    @Test
    public void FurnMapperTest4(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        Furn furn = furnMapper.selectByPrimaryKey(1);
        System.out.println(furn.getId()+"--"+furn.getName()+"--"+furn.getMaker()+"--"+furn.getPrice()+"--"+furn.getSales()+"--"+furn.getStock()+"--"+furn.getImgPath());
    }
}


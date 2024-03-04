package com.hh.furn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hh.furn.bean.Furn;
import com.hh.furn.bean.Msg;
import com.hh.furn.service.FurnService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 黄昊
 * @version 1.0
 **/
@Controller
public class FurnController {
    @Resource
    private FurnService furnService;

    @PostMapping("/save")
    @ResponseBody
    public Msg save(@Validated @RequestBody Furn furn, Errors errors) {
        Map<String,Object> map=new HashMap<>();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        if (map.isEmpty()){
            furnService.save(furn);
            Msg success = Msg.success();
            return success;
        }else {
            return Msg.fail().add("errorMsg",map);
        }
    }
    @RequestMapping("/furns")
    @ResponseBody
    public Msg listFurns(){
        List<Furn> all = furnService.findAll();
        Msg success = Msg.success();
        success.add("furns",all);
        return success;
    }
    @PutMapping("/update")
    @ResponseBody
    public Msg update(@RequestBody Furn furn){
        furnService.update(furn);
        Msg success = Msg.success();
        return success;
    }
    @RequestMapping("/find")
    @ResponseBody
    public Msg findById(int id){
        Furn byId = furnService.findById(id);
        Msg success = Msg.success();
        success.add("furn",byId);
        return success;
    }
    @DeleteMapping("/del/{id}")
    @ResponseBody
    public Msg delete(@PathVariable("id") int id){
        furnService.delete(id);
        Msg success = Msg.success();
        return success;
    }
    @RequestMapping("/furnsByPage")
    @ResponseBody
    public Msg listFurnsByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Furn> all = furnService.findAll();
        PageInfo pageInfo = new PageInfo(all, pageSize);
        return Msg.success().add("pageInfo",pageInfo);
    }
    @RequestMapping("/furnsByConditionPage")
    @ResponseBody
    public Msg listFurnsByConditionPage(@RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "5") Integer pageSize,
                                        @RequestParam(defaultValue = "")String search){
        PageHelper.startPage(pageNum,pageSize);
        List<Furn> all = furnService.findByCondition(search);
        PageInfo pageInfo = new PageInfo(all, pageSize);
        return Msg.success().add("pageInfo",pageInfo);
    }


}

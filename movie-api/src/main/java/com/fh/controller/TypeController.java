package com.fh.controller;

import com.fh.code.ServerResponse;
import com.fh.model.*;
import com.fh.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("TypeController")
public class TypeController {

    @Autowired
    private TypeService typeService;


    @RequestMapping("queryTypeList")
    public ServerResponse queryTypeList(TypeQuery typeQuery) {
        DataTableResult dataTableResult = typeService.queryTypeList(typeQuery);
        return ServerResponse.success(dataTableResult);
    }

    @RequestMapping("addType")
    public ServerResponse addType(Type type) {
        type.setCreateTime(new Date());
        typeService.addType(type);
        return ServerResponse.success();
    }

    @RequestMapping("toUpdateType")
    public ServerResponse toUpdateType(Integer id) {
        Type type = typeService.toUpdateType(id);
        return ServerResponse.success(type);
    }

    @RequestMapping("updateType")
    public ServerResponse updateType(Type type) {
        type.setUpdateTime(new Date());
        typeService.updateType(type);
        return ServerResponse.success();
    }

    @RequestMapping("deleteType")
    public ServerResponse deleteType(Integer id) {
        typeService.deleteType(id);
        return ServerResponse.success();
    }


    @RequestMapping("batchDeleteType")
    public ServerResponse batchDeleteType(@RequestParam("idArr[]")String idArr) {

        String[] ids = idArr.split(",");
        for (String id : ids) {
            typeService.deleteType(Integer.parseInt(id));
        }
        return ServerResponse.success();
    }
}
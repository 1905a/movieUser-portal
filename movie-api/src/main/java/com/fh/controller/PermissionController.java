package com.fh.controller;

import com.fh.code.ServerResponse;
import com.fh.model.Permission;
import com.fh.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("PermissionController")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    //查询  /PermissionController/selectPermissionList.do
    @RequestMapping("selectPermissionList")
    public ServerResponse selectPermissionList(){
        List<Permission> permission =  permissionService.selectPermissionList();
        return ServerResponse.success(permission);
    }

    //新增  /PermissionController/addPermission.do
    @RequestMapping("addPermission")
    public  ServerResponse addPermission(Permission permission){

        permissionService.addPermission(permission);

        return ServerResponse.success();
    }

    //查询单条数据/PermissionController/selectPermissionById.do
    @RequestMapping("selectPermissionById")
    public  ServerResponse selectPermissionById(Integer id){

        Permission permission = permissionService.selectPermissionById(id);

        return ServerResponse.success(permission);
    }

    //修改  /PermissionController/updatePermission.do
    @RequestMapping("updatePermission")
    public ServerResponse updatePermission(Permission permission){

        permissionService.updatePermission(permission);

        return ServerResponse.success();
    }

    //删除  PermissionController/deletePermission.do
    @RequestMapping("deletePermission")
    public ServerResponse deletePermission(@RequestParam("ids[]")List<Integer> ids){

        for(Integer id :ids){
            permissionService.deletePermission(id);
        }
        return ServerResponse.success();
    }


}

package com.fh.controller;

import com.fh.code.ServerResponse;
import com.fh.model.DataTableResult;
import com.fh.model.Role;
import com.fh.model.RoleQuery;
import com.fh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("RoleController")
public class RoleController {

  @Autowired
  private RoleService roleService;


  //查询 /RoleController/selectRoleList.do
  @RequestMapping("selectRoleList")
  public ServerResponse selectRoleList(RoleQuery roleQuery){
    DataTableResult dataTableResult = roleService.selectRoleList(roleQuery);
    return ServerResponse.success(dataTableResult);
  }

  //添加  /RoleController/addRoleOnOnePage.do
  @RequestMapping("addRoleOnOnePage")
  public ServerResponse addRoleOnOnePage(Role role){

      roleService.addRoleOnOnePage(role);
    return ServerResponse.success();
  }

  //回显 /RoleController/toUpdateRoleOnOnePage.do
  @RequestMapping("toUpdateRoleOnOnePage")
  public ServerResponse toUpdateRoleOnOnePage(Integer id){

      Role role = roleService.toUpdateRoleOnOnePage(id);

    return ServerResponse.success(role);
  }
  //修改  /RoleController/updateRoleOnOnePage.do
  @RequestMapping("updateRoleOnOnePage")
  public ServerResponse updateRoleOnOnePage(Role role){

      roleService.updateRoleOnOnePage(role);
    return ServerResponse.success();
  }


  //删除 /RoleController/deleteRole.do
  @RequestMapping("deleteRole")
  public ServerResponse deleteUser(Integer id, HttpServletRequest request){
      roleService.deleteRole(id);
    return ServerResponse.success();
  }


  //禁用启用 /RoleController/updateRoleStatus.do
  @RequestMapping("updateRoleStatus")
  public ServerResponse updateRoleStatus(Integer id){

      Role role = roleService.toUpdateRoleOnOnePage(id);
      roleService.updateRoleStatus(role);

    return ServerResponse.success();
  }

}

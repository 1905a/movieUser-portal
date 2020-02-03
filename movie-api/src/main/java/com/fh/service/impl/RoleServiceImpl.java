package com.fh.service.impl;

import com.fh.mapper.MapperRole;
import com.fh.model.DataTableResult;
import com.fh.model.Role;
import com.fh.model.RoleQuery;
import com.fh.model.User;
import com.fh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private MapperRole mapperRole;

    @Override
    public DataTableResult selectRoleList(RoleQuery roleQuery) {
        Long RoleLong = mapperRole.selectRoleListCount(roleQuery);

        List<Role> roleList = mapperRole.selectRoleList(roleQuery);

        DataTableResult dataTableResult = new DataTableResult(roleQuery.getDraw(),RoleLong,RoleLong,roleList);

        return dataTableResult;
    }

    @Override
    public void addRoleOnOnePage(Role role) {
        role.setCreateDate(new Date());
        mapperRole.addRoleOnOnePage(role);
    }

    @Override
    public Role toUpdateRoleOnOnePage(Integer id) {
        return mapperRole.toUpdateRoleOnOnePage(id);
    }

    @Override
    public void updateRoleOnOnePage(Role role) {
        role.setUpdateDate(new Date());
        mapperRole.updateRoleOnOnePage(role);
    }

    @Override
    public void deleteRole(Integer id) {
        mapperRole.deleteRole(id);
    }

    @Override
    public void updateRoleStatus(Role role) {
        String  status = role.getStatus()==1?"2":"1";
        role.setStatus(Integer.parseInt(status));
        mapperRole.updateRoleStatus(role);
    }
}

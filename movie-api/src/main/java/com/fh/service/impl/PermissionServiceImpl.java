package com.fh.service.impl;

import com.fh.mapper.MapperPermission;
import com.fh.model.Permission;
import com.fh.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private MapperPermission mapperPermission;

    @Override
    public List<Permission> selectPermissionList() {
        return mapperPermission.selectPermissionList();
    }

    @Override
    public void addPermission(Permission permission) {
        permission.setCreateDate(new Date());
        mapperPermission.addPermission(permission);
    }

    @Override
    public Permission selectPermissionById(Integer id) {
        return mapperPermission.selectPermissionById(id);
    }

    @Override
    public void updatePermission(Permission permission) {
        permission.setUpdateDate(new Date());
        mapperPermission.updatePermission(permission);
    }

    @Override
    public void deletePermission(Integer id) {
        mapperPermission.deletePermission(id);
    }
}

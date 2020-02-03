package com.fh.mapper;

import com.fh.model.Permission;

import java.util.List;

public interface MapperPermission {
    List<Permission> selectPermissionList();

    void addPermission(Permission permission);

    Permission selectPermissionById(Integer id);

    void updatePermission(Permission permission);


    void deletePermission(Integer id);
}

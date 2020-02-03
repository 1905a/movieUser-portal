package com.fh.mapper;

import com.fh.model.Role;
import com.fh.model.RoleQuery;
import com.fh.model.User;

import java.util.List;

public interface MapperRole {



    Long selectRoleListCount(RoleQuery roleQuery);

    List<Role> selectRoleList(RoleQuery roleQuery);


    void addRoleOnOnePage(Role role);

    Role toUpdateRoleOnOnePage(Integer id);

    void updateRoleOnOnePage(Role role);

    void deleteRole(Integer id);

    void updateRoleStatus(Role role);
}

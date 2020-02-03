package com.fh.service;

import com.fh.model.DataTableResult;
import com.fh.model.Role;
import com.fh.model.RoleQuery;
import com.fh.model.User;

public interface RoleService {


    DataTableResult selectRoleList(RoleQuery roleQuery);

    void addRoleOnOnePage(Role role);

    Role toUpdateRoleOnOnePage(Integer id);

    void updateRoleOnOnePage(Role role);

    void deleteRole(Integer id);

    void updateRoleStatus(Role role);
}

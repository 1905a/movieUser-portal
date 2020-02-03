package com.fh.service.impl;

import com.fh.mapper.MapperInterface;
import com.fh.model.DataTableResult;
import com.fh.model.User;
import com.fh.model.UserQuery;
import com.fh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MapperInterface mapperInterface;

    @Override
    public DataTableResult selectUserList(UserQuery userQuery) {
        Long drugLong = mapperInterface.selectUserListCount(userQuery);

        List<User> drugList = mapperInterface.selectUserList(userQuery);

        DataTableResult dataTableResult = new DataTableResult(userQuery.getDraw(),drugLong,drugLong,drugList);

        return dataTableResult;
    }

    @Override
    public void addUserOnOnePage(User user) {
        user.setCreateDate(new Date());
        mapperInterface.addUserOnOnePage(user);
    }

    @Override
    public User toUpdateUserOnOnePage(Integer id) {
        User user = mapperInterface.toUpdateUserOnOnePage(id);
        return user;
    }

    @Override
    public void updateUserOnOnePage(User user) {
        user.setUpdateDate(new Date());
        mapperInterface.updateUserOnOnePage(user);
    }

    @Override
    public void deleteUser(Integer id) {
        mapperInterface.deleteUser(id);
    }
}

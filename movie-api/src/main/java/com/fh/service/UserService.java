package com.fh.service;

import com.fh.model.DataTableResult;
import com.fh.model.User;
import com.fh.model.UserQuery;

public interface UserService {
    DataTableResult selectUserList(UserQuery userQuery);

    void addUserOnOnePage(User user);

    User toUpdateUserOnOnePage(Integer id);

    void updateUserOnOnePage(User user);

    void deleteUser(Integer id);
}

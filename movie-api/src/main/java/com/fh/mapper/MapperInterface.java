package com.fh.mapper;

import com.fh.model.User;
import com.fh.model.UserQuery;

import java.util.List;

public interface MapperInterface {
    Long selectUserListCount(UserQuery userQuery);

    List<User> selectUserList(UserQuery userQuery);

    void addUserOnOnePage(User user);

    User toUpdateUserOnOnePage(Integer id);


    void updateUserOnOnePage(User user);

    void deleteUser(Integer id);
}

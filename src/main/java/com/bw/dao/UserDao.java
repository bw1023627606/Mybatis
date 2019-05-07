package com.bw.dao;

import com.bw.entity.User;

import java.util.List;

public interface UserDao {
    User getUserById(int id);

    List<User> getAllUser();

    void insertUser(User user);

    List<User> getUserIf(User user);
}

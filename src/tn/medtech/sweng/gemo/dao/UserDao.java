package tn.medtech.sweng.gemo.dao;

import tn.medtech.sweng.gemo.entities.User;

import java.util.List;

public interface UserDao {
    void insert(User user);
    void update(User user, String userName);
    void delete(int id);
    User selectByUserName(String userName);
    List<User> selectAll();
}

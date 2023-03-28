package com.genspark.ToDoList.service;

import com.genspark.ToDoList.entity.LoginUser;
import com.genspark.ToDoList.entity.User;

public interface UserService {
    public User saveUser(User user);
    public User findByUsername(String username);
    public User findByUserid(int userid);
    public void updateUser(User user);
    public void deleteUser(int userid);
    boolean login(LoginUser user);
}

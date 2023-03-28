package com.genspark.ToDoList.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LoginUserTest {

    @Test
    void blankConstructorTest() {
        LoginUser user = new LoginUser();
        assertEquals("", user.getUsername());
        assertEquals("", user.getPassword());
    }

    @Test
    void getUsernameTest() {
        LoginUser user = new LoginUser("username", "password");
        assertEquals("username", user.getUsername());
    }

    @Test
    void setUsernameTest() {
        LoginUser user = new LoginUser("username", "password");
        user.setUsername("newUsername");
        assertEquals("newUsername", user.getUsername());
    }

    @Test
    void getPasswordTest() {
        LoginUser user = new LoginUser("username", "password");
        assertEquals("password", user.getPassword());
    }

    @Test
    void setPasswordTest() {
        LoginUser user = new LoginUser("username", "password");
        user.setPassword("newPassword");
        assertEquals("newPassword", user.getPassword());
    }
}
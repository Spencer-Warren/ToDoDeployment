package com.genspark.ToDoList.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void setUserid() {
        User user = new User();
        user.setUserid(1);
        assertEquals(1, user.getUserid());
    }

    @Test
    void setUsername() {
        User user = new User();
        user.setUsername("username");
        assertEquals("username", user.getUsername());
    }

    @Test
    void setPassword() {
        User user = new User();
        user.setPassword("password");
        assertEquals("password", user.getPassword());
    }

    @Test
    void setFirstname() {
        User user = new User();
        user.setFirstname("firstname");
        assertEquals("firstname", user.getFirstname());
    }

    @Test
    void setLastname() {
        User user = new User();
        user.setLastname("lastname");
        assertEquals("lastname", user.getLastname());
    }

    @Test
    void testToString() {
        User user = new User(1, "username", "password", "firstname", "lastname");
        assertEquals("User{userid=1, username='username', password='password', firstname='firstname', lastname='lastname'}", user.toString());
    }
}
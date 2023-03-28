package com.genspark.ToDoList.service;

import com.genspark.ToDoList.dao.UserDao;
import com.genspark.ToDoList.entity.Task;
import com.genspark.ToDoList.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserDao userDao;

    @Test
    void saveUserTest() {
        User user = new User(1, "username", "password", "first", "last");
        when(userDao.save(user)).thenReturn(user);

        User actual = service.saveUser(user);

        assertEquals(user, actual);
        verify(userDao, times(1)).save(user);
        verifyNoMoreInteractions(userDao);
    }
}
package com.genspark.ToDoList.service;

import com.genspark.ToDoList.dao.TaskDao;
import com.genspark.ToDoList.entity.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @InjectMocks
    private TaskServiceImpl service;

    @Mock
    private TaskDao taskDao;

    @Test
    void saveTaskTest() {
        Task task = new Task(1, "task", "description", "date", "status", 1);
        when(taskDao.save(task)).thenReturn(task);

        Task actual = service.saveTask(1, task);

        assertEquals(task, actual);
        verify(taskDao, times(1)).save(task);
        verifyNoMoreInteractions(taskDao);
    }
}
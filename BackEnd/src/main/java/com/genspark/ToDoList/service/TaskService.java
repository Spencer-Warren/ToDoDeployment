package com.genspark.ToDoList.service;

import com.genspark.ToDoList.entity.Task;

import java.util.List;

public interface TaskService {
    public List<Task> findAll(int userid);
    public Task saveTask(int userid, Task task);
    public Task findByTaskid(int taskid);
    public void updateTask(int userId, Task task);
    public void deleteTask(int taskid);
}

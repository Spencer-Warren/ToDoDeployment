package com.genspark.ToDoList.service;

import com.genspark.ToDoList.dao.TaskDao;
import com.genspark.ToDoList.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public List<Task> findAll(int userid) {
       return this.taskDao.findAll().stream().filter(task -> task.getUser().getUserid() == userid).toList();
    }

    @Override
    public Task saveTask(int userid, Task task) {
        this.taskDao.save(task);
        return task;
    }

    @Override
    public Task findByTaskid(int taskid) {
        return this.taskDao.findById(taskid).orElse(null);
    }

    @Override
    public void updateTask(int userId, Task task) {
        for (Task t : this.findAll(userId)) {
            if (t.getId() == task.getId()) {
                Task newTask = new Task();
                newTask.setId(t.getId());
                newTask.setDescription(task.getDescription());
                newTask.setDueDate(task.getDueDate());
                newTask.setStatus(task.getStatus());
                newTask.setTitle(task.getTitle());
                newTask.setUser(t.getUser());
                this.taskDao.save(newTask);
            }
        }
    }

    @Override
    public void deleteTask(int taskid) {
        this.taskDao.deleteById(taskid);
    }
}

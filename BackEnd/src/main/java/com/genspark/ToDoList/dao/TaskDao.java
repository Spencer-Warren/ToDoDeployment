package com.genspark.ToDoList.dao;

import com.genspark.ToDoList.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {
    public List<Task> findAllByuserid(int userid);
}

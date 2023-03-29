package com.genspark.ToDoList.dao;

import com.genspark.ToDoList.entity.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {
}

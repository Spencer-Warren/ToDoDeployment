package com.genspark.ToDoList.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private Task taskFactory() {
        return new Task(1, "title", "description", "status", "2021-01-01", 1);
    }

    @Test
    void blankConstructorTest() {
        Task t = new Task();
        assertEquals(0, t.getId());
        assertEquals("", t.getTitle());
        assertEquals("", t.getDescription());
        assertEquals("", t.getStatus());
        assertEquals("", t.getDueDate());
        assertEquals(0, t.getUserid());
    }

    @Test
    void setId() {
        Task t = taskFactory();
        t.setId(2);
        assertEquals(2, t.getId());
    }

    @Test
    void setDescription() {
        Task t = taskFactory();
        t.setDescription("Description 2");
        assertEquals("Description 2", t.getDescription());
    }

    @Test
    void setStatus() {
        Task t = taskFactory();
        t.setStatus("Done");
        assertEquals("Done", t.getStatus());
    }

    @Test
    void setDueDate() {
        Task t = taskFactory();
        t.setDueDate("2022-01-01");
        assertEquals("2022-01-01", t.getDueDate());
    }

    @Test
    void setUserid() {
        Task t = taskFactory();
        t.setUserid(2);
        assertEquals(2, t.getUserid());
    }

    @Test
    void setTitle() {
        Task t = taskFactory();
        t.setTitle("New Title");
        assertEquals("New Title", t.getTitle());
    }
}
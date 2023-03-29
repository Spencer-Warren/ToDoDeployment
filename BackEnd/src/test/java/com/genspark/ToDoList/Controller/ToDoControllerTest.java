package com.genspark.ToDoList.Controller;

import com.genspark.ToDoList.entity.LoginUser;
import com.genspark.ToDoList.entity.Task;
import com.genspark.ToDoList.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@WebMvcTest(ToDoController.class)
public class ToDoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoController toDoController;

    @Test
    public void getUserTest() throws Exception {
        given(toDoController.getUser("username")).willReturn(new User(1, "username", "password", "firstname", "lastname"));
        this.mockMvc.perform(get("/api/user/username"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("username")));
    }
    @Test
    public void getTasksTest () throws Exception {
        given(toDoController.getTasks(1)).willReturn(List.of(new Task(1, "task1", "description1", "Status", "2021-01-01", new User(1, "username", "password", "firstname", "lastname"))));
        this.mockMvc.perform(get("/api/1/tasks"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("task1")));
    }

    @Test
    public void getTaskTest () throws Exception {
        given(toDoController.getTask(1, 1)).willReturn(new Task(1, "task1", "description1", "Status", "2021-01-01", new User(1, "username", "password", "firstname", "lastname")));
        this.mockMvc.perform(get("/api/1/tasks/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("task1")));
    }
}
package com.assecor.usermanager.controller;

import com.assecor.usermanager.bean.User;
import com.assecor.usermanager.service.UserService;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@WebAppConfiguration
public class UserManagerControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    private UserManagerController userManagerController;

    @Autowired
    private UserService userService;

    @Test
    public void getAllUsers_UserEntriesFound_ShouldReturnFoundEntry() throws Exception {

        List<User> userList = new ArrayList<>();

        User user = new User(1L, "Michael", "Banck", "61413", "Neustadt", "lavender");
        userList.add(user);

        when(userService.getAllUsers()).thenReturn(userList);

        mvc.perform(get("/persons"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is(1L)))
                .andExpect(jsonPath("$.lastName", is("Michael")))
                .andExpect(jsonPath("$.zipcode", is("Banck")))
                .andExpect(jsonPath("$.city", is("61413")))
                .andExpect(jsonPath("$.color", is("lavender")));

        verify(userService, times(1)).getAllUsers();
        verifyNoMoreInteractions(userService);

    }

}

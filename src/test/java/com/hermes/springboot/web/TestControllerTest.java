package com.hermes.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TestController.class)
public class TestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test가_리턴된다() throws Exception{
        String test = "test";

        mvc.perform(MockMvcRequestBuilders.get("/test"))
                .andExpect(status().isOk())
                .andExpect(content().string(test));

    }

    @Test
    public void testDto가_리턴된다() throws Exception {
        String name = "이름";
        int amount = 3;

        mvc.perform(MockMvcRequestBuilders.get("/test/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.name", is(name)))
                .andExpect((ResultMatcher) jsonPath("$.amount", is(amount)));
    }

}


package com.nice.exams.examinator.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Evgeny Borisov
 */
@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = ServicesNeededForControllersConfig.class)
public class ExamControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void checkExamineContract() throws Exception {

        mockMvc.perform(
                post("/exams/check")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"title\":\"exam\", \"student\": \"Osnat\" }")
        )
                .andExpect(jsonPath("$.mark", allOf(greaterThan(0), lessThan(101))))
                .andExpect(jsonPath("$.title", equalTo("exam")))
                .andExpect(jsonPath("$.student").doesNotExist())
                .andExpect(status().isOk());

    }


}
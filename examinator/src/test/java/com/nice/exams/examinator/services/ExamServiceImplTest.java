package com.nice.exams.examinator.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ExamServiceMockConfig.class)
public class ExamServiceImplTest {

    @MockBean
    DaoSection daoSection;



    @Autowired
    ExamService examService;

    @Before
    public void setUp() throws Exception {
        Mockito.when(daoSection.getX()).thenReturn("java");
    }

    @Test
    public void getXWithUpperCase() throws Exception {

        String x = examService.getXWithUpperCase();
        System.out.println("x = " + x);
        Assert.assertEquals("JAVA",x);


    }

}
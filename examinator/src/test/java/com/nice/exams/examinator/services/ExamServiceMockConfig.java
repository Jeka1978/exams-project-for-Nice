package com.nice.exams.examinator.services;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Evgeny Borisov
 */
@Configuration
@MockBean(ExamDao.class)
public class ExamServiceMockConfig {
    @Bean
    public ExamService examService(){
        return new ExamServiceImpl();
    }
}

package com.nice.exams.examinator.controllers;

import com.nice.exams.examinator.services.DaoSection;
import com.nice.exams.examinator.services.ExamDao;
import com.nice.exams.examinator.services.ExamService;
import com.nice.exams.examinator.services.ExamServiceImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Evgeny Borisov
 */
@TestConfiguration
@MockBean(DaoSection.class)
@MockBean(ExamDao.class)
public class ServicesNeededForControllersConfig {
    @Bean
    public ExamService examService(){
        return new ExamServiceImpl();
    }
}

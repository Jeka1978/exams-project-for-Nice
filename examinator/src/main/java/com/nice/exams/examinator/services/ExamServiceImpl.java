package com.nice.exams.examinator.services;

import com.nice.exams.examinator.model.CheckedExam;
import com.nice.exams.examinator.model.SolvedExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired(required = false)
    private DaoSection daoSection;
    @Autowired(required = false)
    private ExamDao examDao;

    @Value("${exam.title}")
    private String title;


    @Scheduled(fixedDelay = 1000)
    public void printTitle() {
        System.out.println(title);
    }








    @Override
    public CheckedExam convert(SolvedExam solvedExam) {
        return CheckedExam.builder().exam(solvedExam.getExam()).mark(90).build();
    }

    @Override
    public String getXWithUpperCase() {
        return daoSection.getX().toUpperCase();
    }
}











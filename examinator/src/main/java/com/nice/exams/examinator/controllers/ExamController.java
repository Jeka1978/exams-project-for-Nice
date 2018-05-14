package com.nice.exams.examinator.controllers;

import com.nice.exams.examinator.model.*;
import com.nice.exams.examinator.services.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/exams")
public class ExamController {
    @Autowired
    private RestTemplate restTemplate;


    private static int i;
    @Value("${exam.title}")
    private String title;

    @GetMapping("/title")
    public String getTitle(){
        return title;
    }

    @PostMapping("/exam")
    public Exam createExam(@RequestBody Map<String, Integer> examSpec) {
        List<Section> sections = examSpec.entrySet().stream().map(entry -> {
            String microserviceName = entry.getKey();
            Integer amount = entry.getValue();
            String url = "http://"+microserviceName + "/exercise/random?amount=" + amount;
            List<Exercise> exercises = asList(restTemplate.getForObject(url, Exercise[].class));
            return Section.builder().title(microserviceName).exercises(exercises).build();
        }).collect(toList());
        return Exam.builder().title(title + "#" + ++i).sections(sections).build();
    }


    @Autowired
    private ExamService examService;

    @PostMapping("/check")
    public CheckedExam check(@RequestBody SolvedExam solvedExam) {
        return examService.convert(solvedExam);
    }

    @GetMapping("/hello")
    public Exercise exercise() {
        return Exercise.builder().question("wtf?").answer("nothing").build();

    }

}





package com.nice.exams.java.controllers;

import com.nice.exams.java.model.Exercise;
import com.nice.exams.java.services.JavaExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/exercise")
public class JavaExerciseController {
    @Autowired
    private JavaExercisesService service;

    @GetMapping("/random")
    public List<Exercise> getRandom(@RequestParam("amount") int amount) {
        return service.getRandom(amount);
    }
}

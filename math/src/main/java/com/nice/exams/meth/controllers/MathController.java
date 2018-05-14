package com.nice.exams.meth.controllers;

import com.nice.exams.meth.model.Exercise;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/exercise")
@RefreshScope
public class MathController {
    @Value("${math.max}")
    public int max;
    private Random random = new Random();

    @GetMapping("/random")
    public List<Exercise> getRandom(@RequestParam("amount") int amount) {
        ArrayList<Exercise> exercises = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            exercises.add(generateRandom());
        }
        return exercises;
    }

    private Exercise generateRandom() {
        int a = random.nextInt(max);
        int b = random.nextInt(max);
        String answer = String.valueOf(a + b);
        return Exercise.builder().question(a + " + " + b + " = ?").answer(answer).build();


    }
}

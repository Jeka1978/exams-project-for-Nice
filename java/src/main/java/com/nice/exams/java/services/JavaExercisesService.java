package com.nice.exams.java.services;

import com.nice.exams.java.model.Exercise;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface JavaExercisesService {
    List<Exercise> getRandom(int amount);
}

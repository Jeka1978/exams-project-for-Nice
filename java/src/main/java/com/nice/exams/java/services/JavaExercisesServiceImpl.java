package com.nice.exams.java.services;

import com.nice.exams.java.dao.JavaExercisesRepo;
import com.nice.exams.java.model.Exercise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Service
@RequiredArgsConstructor
@Transactional
public class JavaExercisesServiceImpl implements JavaExercisesService {
    private final JavaExercisesRepo exercisesRepo;
    @Override
    public List<Exercise> getRandom(int amount) {
        List<Exercise> all = exercisesRepo.findAll();
        Collections.shuffle(all);
        return all.subList(0,amount);
    }
}

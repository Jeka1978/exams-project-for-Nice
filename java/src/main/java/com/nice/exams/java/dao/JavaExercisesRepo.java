package com.nice.exams.java.dao;

import com.nice.exams.java.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface JavaExercisesRepo extends JpaRepository<Exercise,Integer> {
}

package com.nice.exams.examinator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Section {
    private String title;
    private List<Exercise> exercises;
}

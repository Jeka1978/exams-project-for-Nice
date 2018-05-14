package com.nice.exams.examinator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

/**
 * @author Evgeny Borisov
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CheckedExam {
    @Delegate
    private Exam exam = new Exam();
    private int mark;
}

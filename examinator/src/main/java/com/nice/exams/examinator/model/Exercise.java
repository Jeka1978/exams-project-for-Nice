package com.nice.exams.examinator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Evgeny Borisov
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Exercise {
    private String question;
    private String answer;
}

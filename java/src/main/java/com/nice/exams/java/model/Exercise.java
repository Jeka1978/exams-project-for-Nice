package com.nice.exams.java.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Evgeny Borisov
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Exercise {
    @Id
    @GeneratedValue
    private int id;
    private String question;
    private String answer;
}








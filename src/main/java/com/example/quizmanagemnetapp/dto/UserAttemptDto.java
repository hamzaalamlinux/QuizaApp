package com.example.quizmanagemnetapp.dto;

import com.example.quizmanagemnetapp.entities.Quizzes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class UserAttemptDto {
    private Long AttemptID;
    private Quizzes quizzes;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int score;
    private  Long QuizID;
}

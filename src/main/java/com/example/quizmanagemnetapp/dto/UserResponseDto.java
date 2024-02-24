package com.example.quizmanagemnetapp.dto;

import com.example.quizmanagemnetapp.entities.Quizzes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDto {
    private Long ResponseID;
    private Long  AttemptId;
    private Long  QuestionId;
    private Long  OptionId;
}

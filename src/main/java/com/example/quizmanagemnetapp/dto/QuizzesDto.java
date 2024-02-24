package com.example.quizmanagemnetapp.dto;

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class QuizzesDto {
    private Long QuizID;

    private String Tittle;

    private String Description;

    private LocalTime TimeLimit;
}

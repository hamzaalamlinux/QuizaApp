package com.example.quizmanagemnetapp.dto;

import com.example.quizmanagemnetapp.entities.Options;
import com.example.quizmanagemnetapp.entities.Questions;
import com.example.quizmanagemnetapp.entities.Quizzes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDto {
    private Long QuestionID;

    private String QuestionText;

    private String QuestionType;

    private Quizzes quizzes;

    private List<Options> options;

    private Long QuizId;
}

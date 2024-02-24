package com.example.quizmanagemnetapp.services;

import com.example.quizmanagemnetapp.entities.Questions;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Questions AddQuestion(Questions questions);
    List<Questions> getQuizzes();
    Questions findQuestionById(Long id);
}

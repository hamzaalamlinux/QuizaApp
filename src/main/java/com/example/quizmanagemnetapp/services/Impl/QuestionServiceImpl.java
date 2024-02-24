package com.example.quizmanagemnetapp.services.Impl;

import com.example.quizmanagemnetapp.entities.Questions;
import com.example.quizmanagemnetapp.exceptions.NotFoundException;
import com.example.quizmanagemnetapp.repository.QuestionRepository;
import com.example.quizmanagemnetapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Questions AddQuestion(Questions questions) {
        return  this.questionRepository.save(questions);
    }
    @Override
    public List<Questions> getQuizzes() {
        return  this.questionRepository.findAll();
    }

    @Override
    public Questions findQuestionById(Long Id) {
        return this.questionRepository.findById(Id)
                .orElseThrow(() -> new NotFoundException("Question with ID " + Id + " not found"));
    }
}

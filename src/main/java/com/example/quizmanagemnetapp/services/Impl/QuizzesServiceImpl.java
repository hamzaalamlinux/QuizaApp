package com.example.quizmanagemnetapp.services.Impl;

import com.example.quizmanagemnetapp.dto.QuizzesDto;
import com.example.quizmanagemnetapp.entities.Quizzes;
import com.example.quizmanagemnetapp.exceptions.NotFoundException;
import com.example.quizmanagemnetapp.repository.QuizzesRepository;
import com.example.quizmanagemnetapp.services.QuizzesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizzesServiceImpl implements QuizzesService {
    @Autowired
    private QuizzesRepository quizzesRepository;


    @Override
    public Quizzes AddQuiz(Quizzes quizzes) {
        return  this.quizzesRepository.save(quizzes);
    }

    @Override
    public List<Quizzes> getAllQuizzes() {
        return this.quizzesRepository.findAll();
    }
    @Override
    public Quizzes findById(Long Id) {
        return  this.quizzesRepository.findById(Id)
                .orElseThrow(() -> new NotFoundException("Quiz With ID" + Id + "Not Found"));
    }
}

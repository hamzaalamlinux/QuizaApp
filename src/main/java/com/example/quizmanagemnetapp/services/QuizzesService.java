package com.example.quizmanagemnetapp.services;

import com.example.quizmanagemnetapp.dto.QuizzesDto;
import com.example.quizmanagemnetapp.entities.Quizzes;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import java.util.List;

public interface QuizzesService {

     Quizzes AddQuiz(Quizzes quizzes);

     List<Quizzes> getAllQuizzes();

     Quizzes findById(Long id);


}

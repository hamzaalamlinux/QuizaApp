package com.example.quizmanagemnetapp.controller;

import com.example.quizmanagemnetapp.dto.QuestionDto;
import com.example.quizmanagemnetapp.entities.Questions;
import com.example.quizmanagemnetapp.entities.Quizzes;
import com.example.quizmanagemnetapp.services.Impl.QuestionServiceImpl;
import com.example.quizmanagemnetapp.services.QuestionService;
import com.example.quizmanagemnetapp.services.QuizzesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/Question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizzesService quizzesService;
    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> AddQuestion(@RequestBody QuestionDto questionDto){
        try{
            Questions questions =  modelMapper.map(questionDto, Questions.class);
            Quizzes existingQuiz = this.quizzesService.findById(questionDto.getQuizId());
            questions.setQuizzes(existingQuiz);
            return ResponseEntity.status(HttpStatus.CREATED).body(this.questionService.AddQuestion(questions));
        }catch (Exception exception){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }
}

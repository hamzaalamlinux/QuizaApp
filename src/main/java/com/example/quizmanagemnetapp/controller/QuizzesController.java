package com.example.quizmanagemnetapp.controller;

import com.example.quizmanagemnetapp.dto.QuizzesDto;
import com.example.quizmanagemnetapp.entities.Quizzes;
import com.example.quizmanagemnetapp.services.QuizzesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Quizzes")
public class QuizzesController {

    @Autowired
    private QuizzesService quizzesService;
    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Quizzes> SaveQuizzes(@RequestBody()  QuizzesDto quizzesDto){
        Quizzes  quizzes =  modelMapper.map(quizzesDto, Quizzes.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.quizzesService.AddQuiz(quizzes));
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Quizzes>> fetchQuizzes(){
        return  ResponseEntity.ok(this.quizzesService.getAllQuizzes());
    }

}

package com.example.quizmanagemnetapp.controller;

import com.example.quizmanagemnetapp.dto.ErrorResponseDto;
import com.example.quizmanagemnetapp.dto.UserAttemptDto;
import com.example.quizmanagemnetapp.entities.Questions;
import com.example.quizmanagemnetapp.entities.Quizzes;
import com.example.quizmanagemnetapp.entities.UserAttempt;
import com.example.quizmanagemnetapp.services.Impl.QuizzesServiceImpl;
import com.example.quizmanagemnetapp.services.Impl.UserAttemptServiceImpl;
import com.example.quizmanagemnetapp.services.QuizzesService;
import com.example.quizmanagemnetapp.services.UserAttemptService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/UserAttempt")
public class UserAttemptController {
    private static final Logger logger = LoggerFactory.getLogger(UserAttemptController.class);
    @Autowired
    private UserAttemptService userAttemptService;
    @Autowired
    private QuizzesService quizzesService;
    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<?> saveAttempt(@RequestBody() UserAttemptDto userAttemptDto){
        try {
                UserAttempt userAttempt =  modelMapper.map(userAttemptDto, UserAttempt.class);
                Quizzes existingQuiz = this
                    .quizzesService.findById(userAttemptDto.getQuizID());
                userAttempt.setQuizzes(existingQuiz);
             return ResponseEntity.status(HttpStatus.CREATED).body(this.userAttemptService.addAttempt(userAttempt));
        }catch (Exception exception){
            logger.error(exception.getMessage());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponseDto(500, "Something went wrong"));
        }
    }
}

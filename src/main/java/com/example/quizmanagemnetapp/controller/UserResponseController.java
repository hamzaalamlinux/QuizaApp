package com.example.quizmanagemnetapp.controller;


import com.example.quizmanagemnetapp.dto.UserResponseDto;
import com.example.quizmanagemnetapp.entities.Options;
import com.example.quizmanagemnetapp.entities.Questions;
import com.example.quizmanagemnetapp.entities.UserAttempt;
import com.example.quizmanagemnetapp.entities.UserResponses;
import com.example.quizmanagemnetapp.services.OptionService;
import com.example.quizmanagemnetapp.services.QuestionService;
import com.example.quizmanagemnetapp.services.UserAttemptService;
import com.example.quizmanagemnetapp.services.UserResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/response")
public class UserResponseController {
    @Autowired
    private OptionService optionService;

    @Autowired
    private UserAttemptService userAttemptService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserResponseService userResponseService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping()
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> AddUserResponse(@RequestBody() UserResponseDto userResponseDto){
            try{
                UserResponses userResponses = this.modelMapper.map(userResponseDto, UserResponses.class);
                /** Find Questions */
                Questions existingQuestion = this.questionService.findQuestionById(userResponseDto.getQuestionId());
                /** Find Attempts */
                UserAttempt existingAttempt = this.userAttemptService.findById(userResponseDto.getAttemptId());
                /** Find Options */
                Options existingOptions = this.optionService.findById(userResponseDto.getOptionId());
                userResponses.setAttempt(existingAttempt);
                userResponses.setQuestion(existingQuestion);
                userResponses.setSelectedOption(existingOptions);
                  return  ResponseEntity.status(HttpStatus.CREATED).body(this.userResponseService.AddResponse(userResponses));
            }catch (Exception exception){
                    return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
            }
    }
}

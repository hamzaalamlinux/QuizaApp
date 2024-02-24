package com.example.quizmanagemnetapp.controller;

import com.example.quizmanagemnetapp.dto.OptionDto;
import com.example.quizmanagemnetapp.entities.Options;
import com.example.quizmanagemnetapp.entities.Questions;
import com.example.quizmanagemnetapp.services.OptionService;
import com.example.quizmanagemnetapp.services.QuestionService;
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
@RequestMapping("api/options")
public class OptionController {
    @Autowired
    private OptionService optionService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private QuestionService questionService;
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> AddOptions(@RequestBody OptionDto optionDto){
        try{
            Options options = modelMapper.map(optionDto, Options.class);
            Questions existingQuestion = this
                    .questionService.findQuestionById(optionDto.getQuestionID());
            options.setQuestions(existingQuestion);
            return ResponseEntity.status(HttpStatus.CREATED).body(this.optionService.AddOptions(options));
        }catch (Exception exception){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }

    }
}

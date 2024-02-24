package com.example.quizmanagemnetapp.dto;

import com.example.quizmanagemnetapp.entities.Questions;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OptionDto {
    private Long OptionID;
    @JsonProperty("Questions")
    private Questions questions;
    private String OptionText;
    private Boolean IsCorrect;
    private  Long QuestionID;
}

package com.example.quizmanagemnetapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long QuestionID;
    private String QuestionText;
    private String QuestionType;
    @JsonIgnore()
    @ManyToOne()
    @JoinColumn(name = "QuizID")
    private Quizzes quizzes;
    @OneToMany(mappedBy = "questions", fetch = FetchType.LAZY)
    private List<Options> options;
}

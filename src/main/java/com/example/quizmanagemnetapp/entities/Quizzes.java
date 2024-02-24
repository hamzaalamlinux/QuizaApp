package com.example.quizmanagemnetapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quizzes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long QuizID;

    private String Tittle;

    private String Description;

    private LocalTime TimeLimit;
    @OneToMany(mappedBy = "quizzes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Questions> questions;

}

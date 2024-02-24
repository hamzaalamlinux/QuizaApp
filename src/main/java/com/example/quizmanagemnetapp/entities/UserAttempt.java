package com.example.quizmanagemnetapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ValueGenerationType;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AttemptID;
    @ManyToOne()
    @JoinColumn(name = "QuizID")
    private Quizzes quizzes;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int score;
}

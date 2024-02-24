package com.example.quizmanagemnetapp.repository;

import com.example.quizmanagemnetapp.entities.Quizzes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizzesRepository extends JpaRepository<Quizzes, Long> {

}

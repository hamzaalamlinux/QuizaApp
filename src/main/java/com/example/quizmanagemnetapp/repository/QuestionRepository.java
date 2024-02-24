package com.example.quizmanagemnetapp.repository;

import com.example.quizmanagemnetapp.entities.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Questions, Long> {
}

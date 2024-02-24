package com.example.quizmanagemnetapp.repository;

import com.example.quizmanagemnetapp.entities.UserAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAttemptRepository extends JpaRepository<UserAttempt, Long> {

}

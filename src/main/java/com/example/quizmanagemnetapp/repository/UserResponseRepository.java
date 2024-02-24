package com.example.quizmanagemnetapp.repository;

import com.example.quizmanagemnetapp.entities.UserResponses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResponseRepository extends JpaRepository<UserResponses, Long> {
}

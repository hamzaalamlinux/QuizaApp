package com.example.quizmanagemnetapp.services;

import com.example.quizmanagemnetapp.entities.UserAttempt;

import java.util.List;

public interface UserAttemptService {
    UserAttempt addAttempt(UserAttempt userAttempt);
    List<UserAttempt> getAttempt();
    UserAttempt findById(Long Id);

}

package com.example.quizmanagemnetapp.services;

import com.example.quizmanagemnetapp.entities.UserResponses;

import java.util.List;

public interface UserResponseService {
    UserResponses AddResponse(UserResponses userResponses);
    List<UserResponses> getAllResponse();
    UserResponses findById(Long Id);
}

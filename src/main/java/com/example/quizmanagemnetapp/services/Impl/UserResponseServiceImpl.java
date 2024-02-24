package com.example.quizmanagemnetapp.services.Impl;

import com.example.quizmanagemnetapp.entities.UserResponses;
import com.example.quizmanagemnetapp.exceptions.NotFoundException;
import com.example.quizmanagemnetapp.repository.UserResponseRepository;
import com.example.quizmanagemnetapp.services.UserResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserResponseServiceImpl implements UserResponseService {
    @Autowired
    private UserResponseRepository userResponseRepository;
    @Override
    public UserResponses AddResponse(UserResponses userResponses) {
        return  userResponseRepository.save(userResponses);
    }

    @Override
    public List<UserResponses> getAllResponse() {
        return  userResponseRepository.findAll();
    }

    @Override
    public UserResponses findById(Long Id) {
        return  this.userResponseRepository.findById(Id)
                .orElseThrow(() -> new NotFoundException("Response Not Found"));
    }
}

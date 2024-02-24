package com.example.quizmanagemnetapp.services.Impl;

import com.example.quizmanagemnetapp.entities.UserAttempt;
import com.example.quizmanagemnetapp.exceptions.NotFoundException;
import com.example.quizmanagemnetapp.repository.UserAttemptRepository;
import com.example.quizmanagemnetapp.services.UserAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserAttemptServiceImpl implements UserAttemptService {
  @Autowired
  private UserAttemptRepository userAttemptRepository;
    @Override
    public UserAttempt addAttempt(UserAttempt userAttempt) {
        return  this.userAttemptRepository.save(userAttempt);
    }

    @Override
    public List<UserAttempt> getAttempt() {
        return  this.userAttemptRepository.findAll();
    }

    @Override
    public UserAttempt findById(Long Id) {
        return  this.userAttemptRepository.findById(Id)
                .orElseThrow(() ->  new NotFoundException("Attempt Not Found"));
    }

}

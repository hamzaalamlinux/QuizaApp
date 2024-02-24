package com.example.quizmanagemnetapp.services;

import com.example.quizmanagemnetapp.entities.Options;

public interface OptionService {
     Options AddOptions(Options options);

     Options findById(Long Id);

}

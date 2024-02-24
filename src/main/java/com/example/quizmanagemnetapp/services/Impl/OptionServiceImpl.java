package com.example.quizmanagemnetapp.services.Impl;

import com.example.quizmanagemnetapp.entities.Options;
import com.example.quizmanagemnetapp.exceptions.NotFoundException;
import com.example.quizmanagemnetapp.repository.OptionRepository;
import com.example.quizmanagemnetapp.services.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionRepository optionRepository;
    @Override
    public Options AddOptions(Options options) {
        return this.optionRepository.save(options);
    }

    @Override
    public Options findById(Long Id) {
        return  this.optionRepository.findById(Id)
                .orElseThrow(() -> new NotFoundException("Options Not Found"));
    }
}

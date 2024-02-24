package com.example.quizmanagemnetapp.repository;

import com.example.quizmanagemnetapp.entities.Options;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Options, Long> {

}

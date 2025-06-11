package com.vscodepruebavet.vscodepruebavet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vscodepruebavet.vscodepruebavet.model.Duenio;

@Repository
public interface DuenioRepository extends JpaRepository <Duenio, Long> {
    
}


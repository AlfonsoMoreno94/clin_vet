package com.vscodepruebavet.vscodepruebavet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vscodepruebavet.vscodepruebavet.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository <Mascota, Long> {

    
}


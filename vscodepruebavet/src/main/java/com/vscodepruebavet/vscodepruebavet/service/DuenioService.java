package com.vscodepruebavet.vscodepruebavet.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vscodepruebavet.vscodepruebavet.model.Duenio;
import com.vscodepruebavet.vscodepruebavet.repository.DuenioRepository;

@Service
public class DuenioService implements IDuenioService {
    
        @Autowired
    private DuenioRepository duenioRepo;

    @Override
    public void createDuenio(Duenio due) {
            
        duenioRepo.save(due);
    
    }

    @Override
    public List<Duenio> getDuenios() {
        
        return duenioRepo.findAll();
    
    }

    @Override
    public void deleteDuenio(Long id) {
        
        duenioRepo.deleteById(id);
    
    }

    
    @Override
    public Duenio getDuenio(Long id) {
        return duenioRepo.findById(id).orElse(null);
    }
    
    
    @Override
    public Duenio editDuenio(Long id, Duenio due) {
       duenioRepo.save(due);
       
       return this.getDuenio(id);
               }

    @Override
    public List<Duenio> getDueniosByAttributes(String nombre, String apellido, String dni, String celular) {
            List<Duenio> todas = this.getDuenios();

    return todas.stream()
        .filter(d -> nombre == null || d.getNombre().contains(nombre))
        .filter(d -> apellido == null || d.getApellido().contains(apellido))
        .filter(d -> dni == null || d.getDni().contains(dni))
        .filter(d -> celular == null || d.getCelular().contains(celular))
        .collect(Collectors.toList());}
    
}
    

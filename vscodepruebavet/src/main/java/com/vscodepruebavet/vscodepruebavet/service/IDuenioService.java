package com.vscodepruebavet.vscodepruebavet.service;

import java.util.List;

import com.vscodepruebavet.vscodepruebavet.model.Duenio;


public interface IDuenioService {
    
    public void createDuenio(Duenio due);

    public List<Duenio> getDuenios();
    
    public Duenio getDuenio(Long id);

    public void deleteDuenio(Long id);

    public Duenio editDuenio(Long id, Duenio due);

    public List<Duenio> getDueniosByAttributes(String nombre, String apellidos, String dni, String celular);
    
}

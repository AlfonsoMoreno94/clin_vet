package com.vscodepruebavet.vscodepruebavet.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vscodepruebavet.vscodepruebavet.dto.DTOMascoDuenio;
import com.vscodepruebavet.vscodepruebavet.model.Duenio;
import com.vscodepruebavet.vscodepruebavet.model.Mascota;
import com.vscodepruebavet.vscodepruebavet.repository.DuenioRepository;
import com.vscodepruebavet.vscodepruebavet.repository.MascotaRepository;

@Service
public class MascotaService implements IMascotaService {
    
    @Autowired
    private MascotaRepository mascoRepo;
    @Autowired
    private DuenioRepository duenioRepo;

    @Override
    public void createMascota(Mascota masco) {
            
        mascoRepo.save(masco);
    
    }

    @Override
    public List<Mascota> getMascotas() {
        
        return mascoRepo.findAll();
    
    }

    @Override
    public void deleteMasco(Long id) {
        
        mascoRepo.deleteById(id);
    
    }

    
    @Override
    public Mascota getMascota(Long id) {
        return mascoRepo.findById(id).orElse(null);
    }
    
    
    @Override
    public Mascota editMascota(Long id, Mascota masco) {
       mascoRepo.save(masco);
       
       return this.getMascota(id);
               }

    @Override
    public List<Mascota> getMascotasByAttributes(String nombre, String raza, String especie, String color) {
            List<Mascota> todas = this.getMascotas();

    return todas.stream()
        .filter(m -> nombre == null || m.getNombre().contains(nombre))
        .filter(m -> raza == null || m.getRaza().contains(raza))
        .filter(m -> especie == null || m.getEspecie().contains(especie))
        .filter(m -> color == null || m.getColor().contains(color))
        .collect(Collectors.toList());}

    @Override
    public DTOMascoDuenio getDatos(Long id) {
        
        Mascota masco = this.getMascota(id);
        Duenio due = duenioRepo.findById(id).orElse(null);
        
        DTOMascoDuenio dto = new DTOMascoDuenio();
        
        dto.setNombre_mascota(masco.getNombre());
        dto.setEspecie(masco.getEspecie());
        dto.setRaza(masco.getRaza());
        dto.setNombre_duenio(due.getNombre());
        dto.setAppelido_duenio(due.getApellido());
        
        return dto;
    
    }
    
}

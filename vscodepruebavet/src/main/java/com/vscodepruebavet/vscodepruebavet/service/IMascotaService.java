package com.vscodepruebavet.vscodepruebavet.service;

import java.util.List;

import com.vscodepruebavet.vscodepruebavet.dto.DTOMascoDuenio;
import com.vscodepruebavet.vscodepruebavet.model.Mascota;


public interface IMascotaService {

    public void createMascota(Mascota masco);

    public List<Mascota> getMascotas();
    
    public Mascota getMascota(Long id);

    public void deleteMasco(Long id);

    public Mascota editMascota(Long id, Mascota masco);

    public List<Mascota> getMascotasByAttributes(String nombre, String raza, String especie, String color);

    public DTOMascoDuenio getDatos(Long id);
    
}

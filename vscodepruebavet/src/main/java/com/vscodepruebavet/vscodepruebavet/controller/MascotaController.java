package com.vscodepruebavet.vscodepruebavet.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vscodepruebavet.vscodepruebavet.dto.DTOMascoDuenio;
import com.vscodepruebavet.vscodepruebavet.model.Mascota;
import com.vscodepruebavet.vscodepruebavet.service.IMascotaService;

@RestController
public class MascotaController {
    
        @Autowired
    private IMascotaService mascoService;
    
    @PostMapping ("/mascotas/crear")
    public String createMascota(@RequestBody Mascota masco) {
        
        mascoService.createMascota(masco);
        return "Mascota creada con éxito";
        
    }
    
    @GetMapping ("/mascotas/traer")
    public List<Mascota> getMascotas() {
        
        List<Mascota> listaMascotas = mascoService.getMascotas();
        return listaMascotas;
        
    }
    
    @DeleteMapping ("/mascotas/delete/{id}")
    public String deleteMascota(@PathVariable Long id) {
        
        mascoService.deleteMasco(id);
        return "Mascota eliminada con éxito";
        
    }
    
    @PutMapping ("/mascotas/editar/{id}")
    public Mascota editMascota(@PathVariable Long id,
                                            @RequestBody Mascota masco) {
        
        return mascoService.editMascota(id, masco);
        
    }
    
    
    @GetMapping ("/mascotas/buscar/nombres")
    public List<Mascota> getMascotasByName(@RequestParam (required = false) String nombre,
                                                                            @RequestParam (required = false) String raza,
                                                                             @RequestParam (required = false) String especie,
                                                                             @RequestParam (required = false) String color) {
        
        return mascoService.getMascotasByAttributes(nombre, raza, especie, color);
        
    }
    
    @GetMapping ("/mascotas/datos/{id}")
    public DTOMascoDuenio getDatos(@PathVariable Long id) {
        
        return mascoService.getDatos(id);
        
    }
    
}

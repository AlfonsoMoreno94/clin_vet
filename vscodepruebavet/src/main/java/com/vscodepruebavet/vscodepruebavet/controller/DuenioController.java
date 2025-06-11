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

import com.vscodepruebavet.vscodepruebavet.model.Duenio;
import com.vscodepruebavet.vscodepruebavet.service.IDuenioService;

@RestController
public class DuenioController {
    
            @Autowired
    private IDuenioService duenioService;
    
    @PostMapping ("/duenios/crear")
    public String createDuenio(@RequestBody Duenio due) {
        
        duenioService.createDuenio(due);
        return "Dueño creado con éxito";
        
    }
    
    @GetMapping ("/duenios/traer")
    public List<Duenio> getDuenios() {
        
        List<Duenio> listaDuenios = duenioService.getDuenios();
        return listaDuenios;
        
    }
    
    @DeleteMapping ("/duenios/delete/{id}")
    public String deleteDuenio(@PathVariable Long id) {
        
        duenioService.deleteDuenio(id);
        return "Dueño eliminado con éxito";
        
    }
    
    @PutMapping ("/duenios/editar/{id}")
    public Duenio editDuenio (@PathVariable Long id,
                                            @RequestBody Duenio due) {
        
        return duenioService.editDuenio(id, due);
        
    }
    
    
    @GetMapping ("/duenios/buscar/nombres")
    public List<Duenio> getDueniosByAttributes(@RequestParam (required = false) String nombre,
                                                                            @RequestParam (required = false) String apellido,
                                                                             @RequestParam (required = false) String dni,
                                                                             @RequestParam (required = false) String celular) {
        
        return duenioService.getDueniosByAttributes(nombre, apellido, dni, celular);
        
    }
    
    
}

package com.vscodepruebavet.vscodepruebavet.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOMascoDuenio implements Serializable {
    
    private String nombre_mascota;
    private String especie;
    private String raza;
    private String nombre_duenio;
    private String appelido_duenio;

    public DTOMascoDuenio() {
    }

    public DTOMascoDuenio(String nombre_mascota, String especie, String raza, String nombre_duenio, String appelido_duenio) {
        this.nombre_mascota = nombre_mascota;
        this.especie = especie;
        this.raza = raza;
        this.nombre_duenio = nombre_duenio;
        this.appelido_duenio = appelido_duenio;
    }
}

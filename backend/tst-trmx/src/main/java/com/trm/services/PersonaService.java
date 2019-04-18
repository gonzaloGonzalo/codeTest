package com.trm.services;

import com.trm.entity.Persona;

import javax.ws.rs.core.Response;

public interface PersonaService {

    Response obtenerPersonas();
    Response agregarPersona(Persona persona);
    Response actualizarPersona(Persona persona);
    Response eliminarPersona(Persona persona);
}

package com.trm.dao;

import com.trm.entity.Persona;

import java.util.List;

public interface PersonaDAO {
    public List<Persona> obtenerTodos();
    public Long guardarPersona(Persona persona);
    public Long actualizarPersona(Persona idPersona);
    public Long eliminarPersona(Persona idPersona);
}

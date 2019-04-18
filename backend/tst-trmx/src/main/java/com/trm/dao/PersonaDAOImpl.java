package com.trm.dao;

import com.trm.entity.Persona;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service("personaDAO")
public class PersonaDAOImpl implements PersonaDAO{

    @PersistenceContext
    public EntityManager entityManager;

    public List<Persona> obtenerTodos() {
        Query query  = entityManager.createQuery("from Persona");
        return query.getResultList();
    }

    public Long guardarPersona(Persona persona) {
        entityManager.persist(persona);
        return persona.getId();
    }

    public Long actualizarPersona(Persona persona) {
        Query query  = entityManager.createQuery("update Persona set " +
                "apellido = :apellido, " +
                "nombre = :nombre, " +
                "numeroDocumento = :numeroDocumento," +
                "tipoDocumento = :tipoDocumento " +
                "where id = :id");
        query.setParameter("apellido", persona.getApellido());
        query.setParameter("nombre", persona.getNombre());
        query.setParameter("numeroDocumento", persona.getNumeroDocumento());
        query.setParameter("tipoDocumento", persona.getTipoDocumento());
        query.setParameter("id", persona.getId());
        query.executeUpdate();
        return persona.getId();
    }

    public Long eliminarPersona(Persona persona) {
        Query query  = entityManager.createQuery("delete from Persona where id = :id");
        query.setParameter("id", persona.getId());
        query.executeUpdate();
        return persona.getId();
    }
}

package com.trm.services;

import org.apache.log4j.Logger;
import com.trm.dao.PersonaDAO;
import com.trm.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Service("personaService")
@Transactional(propagation= Propagation.REQUIRED)
public class PersonaServiceImpl implements PersonaService {

    private static Logger logger = Logger.getLogger(PersonaServiceImpl.class);

    @Autowired(required=true)
    private PersonaDAO personaDAO;

    public Response obtenerPersonas() {
        try {
            List<Persona> listaPersonas = personaDAO.obtenerTodos();
            return Response
                    .status(Response.Status.OK)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Headers",
                            "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Methods",
                            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .entity(listaPersonas)
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }catch (Exception ex){
            logger.error("ERROR EN APLICACION: NO SE PUEDEN OBTENER PERSONAS.");
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    public Response agregarPersona(Persona persona) {
        try{
            Long idPersona = personaDAO.guardarPersona(persona);
            return Response
                    .status(Response.Status.OK)
                    .entity(String.format("PERSONA AGREGADA %s",  String.valueOf(idPersona)))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }catch (Exception ex){
            logger.error("ERROR EN APLICACION: NO SE PUEDE AGREGAR PERSONA.");
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("NO SE PUEDE AGREGAR PERSONA")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }

    public Response actualizarPersona(Persona persona) {
        try{
            Long idPersona = personaDAO.actualizarPersona(persona);
            return Response
                    .status(Response.Status.OK)
                    .entity(String.format("PERSONA ACTUALIZADA %s",  String.valueOf(idPersona)))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }catch (Exception ex){
            logger.error("ERROR EN APLICACION: NO SE PUEDE ACTUALIZAR PERSONA.");
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("NO SE PUEDE ACTUALIZAR PERSONA")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }

    public Response eliminarPersona(Persona persona) {
        try{
            personaDAO.eliminarPersona(persona);
            return Response
                    .status(Response.Status.OK)
                    .entity(String.format("PERSONA ELIMINADA DEL REGISTRO "))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }catch (Exception ex){
            logger.error("ERROR EN APLICACION: NO SE PUEDE ELIMINAR PERSONA.");
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("NO SE PUEDE ELIMINAR PERSONA DEL REGISTRO")
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }
}

package com.trm.controller;

import com.trm.entity.Persona;
import com.trm.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/api")
public class RestResource {

	@Autowired(required=true)
	@Qualifier("personaService")
	private PersonaService personaService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/personas")
	public Response obtenerPersonas() {
		return personaService.obtenerPersonas();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/personas/nombre")
	public Response obtenerPersonasPorNombre(@QueryParam("nombre")String nombre) {
		return personaService.obtenerPersonasPorNombre(nombre);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/personas/documento")
	public Response obtenerPersonasPorDocumento(@QueryParam("documento")String documento) {
		return personaService.obtenerPersonasPorTipoDeDocument(documento);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/persona")
	public Response agregarPersona(Persona persona){
		return personaService.agregarPersona(persona);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/persona")
	public Response actualizarPersona(Persona persona){
		return personaService.actualizarPersona(persona);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/persona")
	public Response eliminarPersona(Persona persona){
		return personaService.eliminarPersona(persona);
	}


}

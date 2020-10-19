package com.asofi.servrest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.asofi.servrest.entity.Riesgo;

@Path("/servicioriesgos")
public interface ServicioRiesgos {
	@Path("/riesgos")
	@GET
	List<Riesgo> obtenerRiesgos();
	
	@Path("/Riesgo/{id}")
	@GET
	Riesgo obtenerRiesgo(@PathParam("id") Long id);
	
	@Path("/proyectos/")
	@POST
	Response crearRiesgo(Riesgo riesgo);
	
	@Path("/proyectos/")
	@PUT
	Response actualizarRiesgo(Riesgo riesgo);
}

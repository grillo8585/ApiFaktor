package com.asofi.servrest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.asofi.servrest.entity.Empresa;
import com.asofi.servrest.entity.Proyecto;

@Path("/servicioproyectos")
public interface ServicioProyectos {
	@Path("/proyectos")
	@GET
	List<Proyecto> obtenerProyectos();
	
	@Path("/proyectos/{id}")
	@GET
	Proyecto obtenerProyecto(@PathParam("id") Long id);
	
	@Path("/proyectos/{id}/empresas/{ide}")
	@GET
	Empresa obtenerProyectoEmpresa(@PathParam("id") Long id,@PathParam("ide") Long ide);
	@Path("/proyectos/")
	@POST
	Response crearProyecto(Proyecto proyecto);
	
	@Path("/proyectos/")
	@PUT
	Response actualizarProyecto(Proyecto proyecto);
}

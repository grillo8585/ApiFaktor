package com.asofi.servrest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.asofi.servrest.modelo.Proyectos;
import com.asofi.servrest.modelo.Empresas;

@Path("/servicioproyectos")
public interface ServicioProyectos {
	@Path("/proyectos")
	@GET
	List<Proyectos> obtenerProyectos();
	
	@Path("/proyectos/{id}")
	@GET
	Proyectos obtenerProyecto(@PathParam("id") Long id);
	
	@Path("/proyectos/{id}/empresas/{ide}")
	@GET
	Empresas obtenerProyectoEmpresa(@PathParam("id") Long id,@PathParam("ide") Long ide);
	@Path("/proyectos/")
	@POST
	Response crearProyecto(Proyectos proyecto);
	
	@Path("/proyectos/")
	@PUT
	Response actualizarProyecto(Proyectos proyecto);
}

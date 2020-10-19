package com.asofi.servrest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.asofi.servrest.entity.Empresa;

@Path("/servicio")
public interface ServicioEmpresas {
	@Path("/empresas")
	@GET
	List<Empresa> obtenerEmpresas();
	
	@Path("/empresas/{id}")
	@GET
	Empresa obtenerEmpresa(@PathParam("id") Long id);
	
	@Path("/empresas/")
	@POST
	Response crearEmpresa(Empresa Empresa);
	
	@Path("/empresas/")
	@PUT
	Response actualizarEmpresa(Empresa Empresa);
}

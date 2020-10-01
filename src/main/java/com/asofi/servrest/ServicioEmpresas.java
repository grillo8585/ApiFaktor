package com.asofi.servrest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.asofi.servrest.modelo.Empresas;

@Path("/servicio")
public interface ServicioEmpresas {
	@Path("/empresas")
	@GET
	List<Empresas> obtenerEmpresas();
	
	@Path("/empresas/{id}")
	@GET
	Empresas obtenerEmpresa(@PathParam("id") Long id);
	
	@Path("/empresas/")
	@POST
	Response crearEmpresa(Empresas Empresa);
	
	@Path("/empresas/")
	@PUT
	Response actualizarEmpresa(Empresas Empresa);
}

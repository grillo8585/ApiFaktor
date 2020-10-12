package com.asofi.servrest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.asofi.servrest.entity.Empleado;

@Path("/servicio")
public interface ServicioEmpleado {
	@Path("/empleados")
	@GET
	List<Empleado> obtenerEmpleados();
	
	@Path("/empleados/{id}")
	@GET
	Empleado obtenerEmpleado(@PathParam("id") Long id);
	
	@Path("/empleados/")
	@POST
	Response crearEmpleado(Empleado empleado);
	
	@Path("/empleados/")
	@PUT
	Response actualizarEmpleado(Empleado empleado);
}

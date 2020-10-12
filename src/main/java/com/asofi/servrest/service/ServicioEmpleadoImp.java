package com.asofi.servrest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.asofi.servrest.entity.Empleado;

@Service
public class ServicioEmpleadoImp implements ServicioEmpleado {
	Map<Long, Empleado> empleados = new HashMap<>();
	long idActual = 123;

	public ServicioEmpleadoImp() {
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		Empleado empleado = new Empleado();
		empleado.setId(idActual);
		empleado.setNombre("Pacho");
		empleados.put(empleado.getId(), empleado);

	}

	@Override
	public List<Empleado> obtenerEmpleados() {
		// TODO Auto-generated method stub
		Collection<Empleado> resultado = empleados.values();
		List<Empleado> respuesta = new ArrayList<>(resultado);
		return respuesta;
	}

	@Override
	public Empleado obtenerEmpleado(Long id) {
		// TODO Auto-generated method stub
		return empleados.get(id);
	}

	@Override
	public Response crearEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		empleado.setId(++idActual);
		;
		empleados.put(empleado.getId(), empleado);

		return Response.ok(empleado).build();
	}

	@Override
	public Response actualizarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		Empleado empleadoActual = empleados.get(empleado.getId());
		Response respuesta;
		if (empleadoActual != null) {
			empleados.put(empleadoActual.getId(), empleado);
			respuesta = Response.ok(empleado).build();
		} else {
			respuesta = Response.notModified().build();
		}

		return respuesta;
	}
}

package com.asofi.servrest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.asofi.servrest.entity.Empresa;
import com.asofi.servrest.entity.Proyecto;

@Service
public class ServicioProyectosImp implements ServicioProyectos {
	Map<Long, Proyecto > proyectos = new HashMap<>();
	long idActual = 123;

	public ServicioProyectosImp() {
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		Proyecto proyecto = new Proyecto();
		proyecto.setId(idActual);
		proyecto.setNombre("Pacho");
		proyectos.put(proyecto.getId(), proyecto);

	}

	@Override
	public List<Proyecto> obtenerProyectos() {
		// TODO Auto-generated method stub
		Collection<Proyecto> resultado = proyectos.values();
		List<Proyecto> respuesta = new ArrayList<>(resultado);
		return respuesta;
	}

	@Override
	public Proyecto obtenerProyecto(Long id) {
		// TODO Auto-generated method stub
		return proyectos.get(id);
	}

	@Override
	public Response crearProyecto(Proyecto Proyecto) {
		// TODO Auto-generated method stub
		Proyecto.setId(++idActual);
		;
		proyectos.put(Proyecto.getId(), Proyecto);

		return Response.ok(proyectos).build();
	}

	@Override
	public Response actualizarProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		Proyecto proyectoActual = proyectos.get(proyecto.getId());
		Response respuesta;
		if (proyectoActual != null) {
			proyectos.put(proyectoActual.getId(), proyecto);
			respuesta = Response.ok(proyecto).build();
		} else {
			respuesta = Response.notModified().build();
		}

		return respuesta;
	}

	@Override
	public Empresa obtenerProyectoEmpresa(Long id, Long ide) {
		// TODO Auto-generated method stub
		return null;
	}
}

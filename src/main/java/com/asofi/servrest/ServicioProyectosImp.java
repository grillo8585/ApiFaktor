package com.asofi.servrest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.asofi.servrest.entity.Empresas;
import com.asofi.servrest.entity.Proyectos;

@Service
public class ServicioProyectosImp implements ServicioProyectos {
	Map<Long, Proyectos > proyectos = new HashMap<>();
	long idActual = 123;

	public ServicioProyectosImp() {
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		Proyectos proyecto = new Proyectos();
		proyecto.setId(idActual);
		proyecto.setNombre("Pacho");
		proyectos.put(proyecto.getId(), proyecto);

	}

	@Override
	public List<Proyectos> obtenerProyectos() {
		// TODO Auto-generated method stub
		Collection<Proyectos> resultado = proyectos.values();
		List<Proyectos> respuesta = new ArrayList<>(resultado);
		return respuesta;
	}

	@Override
	public Proyectos obtenerProyecto(Long id) {
		// TODO Auto-generated method stub
		return proyectos.get(id);
	}

	@Override
	public Response crearProyecto(Proyectos Proyecto) {
		// TODO Auto-generated method stub
		Proyecto.setId(++idActual);
		;
		proyectos.put(Proyecto.getId(), Proyecto);

		return Response.ok(proyectos).build();
	}

	@Override
	public Response actualizarProyecto(Proyectos proyecto) {
		// TODO Auto-generated method stub
		Proyectos proyectoActual = proyectos.get(proyecto.getId());
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
	public Empresas obtenerProyectoEmpresa(Long id, Long ide) {
		// TODO Auto-generated method stub
		return null;
	}
}

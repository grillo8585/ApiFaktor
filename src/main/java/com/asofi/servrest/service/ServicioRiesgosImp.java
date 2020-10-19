package com.asofi.servrest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.asofi.servrest.entity.Riesgo;

@Service
public class ServicioRiesgosImp implements ServicioRiesgos {
	Map<Long, Riesgo > riesgos = new HashMap<>();
	long idActual = 123;

	public ServicioRiesgosImp() {
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		Riesgo riesgo = new Riesgo();
		riesgo.setId(idActual);
		riesgo.setNombre("Pacho");
		riesgos.put(riesgo.getId(), riesgo);

	}

	@Override
	public List<Riesgo> obtenerRiesgos() {
		// TODO Auto-generated method stub
		Collection<Riesgo> resultado = riesgos.values();
		List<Riesgo> respuesta = new ArrayList<>(resultado);
		return respuesta;
	}

	@Override
	public Riesgo obtenerRiesgo(Long id) {
		// TODO Auto-generated method stub
		return riesgos.get(id);
	}

	@Override
	public Response crearRiesgo(Riesgo riesgo) {
		// TODO Auto-generated method stub
		riesgo.setId(++idActual);
		
		riesgos.put(riesgo.getId(), riesgo);

		return Response.ok(riesgos).build();
	}

	@Override
	public Response actualizarRiesgo(Riesgo riesgo) {
		// TODO Auto-generated method stub
		Riesgo riesgoActual = riesgos.get(riesgo.getId());
		Response respuesta;
		if (riesgoActual != null) {
			riesgos.put(riesgoActual.getId(), riesgo);
			respuesta = Response.ok(riesgo).build();
		} else {
			respuesta = Response.notModified().build();
		}

		return respuesta;
	}
}

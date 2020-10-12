package com.asofi.servrest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.asofi.servrest.entity.Riesgos;

@Service
public class ServicioRiesgosImp implements ServicioRiesgos {
	Map<Long, Riesgos > riesgos = new HashMap<>();
	long idActual = 123;

	public ServicioRiesgosImp() {
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		Riesgos riesgo = new Riesgos();
		riesgo.setId(idActual);
		riesgo.setNombre("Pacho");
		riesgos.put(riesgo.getId(), riesgo);

	}

	@Override
	public List<Riesgos> obtenerRiesgos() {
		// TODO Auto-generated method stub
		Collection<Riesgos> resultado = riesgos.values();
		List<Riesgos> respuesta = new ArrayList<>(resultado);
		return respuesta;
	}

	@Override
	public Riesgos obtenerRiesgo(Long id) {
		// TODO Auto-generated method stub
		return riesgos.get(id);
	}

	@Override
	public Response crearRiesgo(Riesgos riesgo) {
		// TODO Auto-generated method stub
		riesgo.setId(++idActual);
		
		riesgos.put(riesgo.getId(), riesgo);

		return Response.ok(riesgos).build();
	}

	@Override
	public Response actualizarRiesgo(Riesgos riesgo) {
		// TODO Auto-generated method stub
		Riesgos riesgoActual = riesgos.get(riesgo.getId());
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

package com.asofi.servrest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.asofi.servrest.modelo.Empresas;

@Service
public class ServicioEmpresasImp implements ServicioEmpresas {
	Map<Long, Empresas > empresas = new HashMap<>();
	long idActual = 123;

	public ServicioEmpresasImp() {
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		Empresas empresa = new Empresas();
		empresa.setId(idActual);
		empresa.setNombre("Pacho");
		empresas.put(empresa.getId(), empresa);

	}

	@Override
	public List<Empresas> obtenerEmpresas() {
		// TODO Auto-generated method stub
		Collection<Empresas> resultado = empresas.values();
		List<Empresas> respuesta = new ArrayList<>(resultado);
		return respuesta;
	}

	@Override
	public Empresas obtenerEmpresa(Long id) {
		// TODO Auto-generated method stub
		return empresas.get(id);
	}

	@Override
	public Response crearEmpresa(Empresas Empresa) {
		// TODO Auto-generated method stub
		Empresa.setId(++idActual);
		;
		empresas.put(Empresa.getId(), Empresa);

		return Response.ok(empresas).build();
	}

	@Override
	public Response actualizarEmpresa(Empresas empresa) {
		// TODO Auto-generated method stub
		Empresas empresaActual = empresas.get(empresa.getId());
		Response respuesta;
		if (empresaActual != null) {
			empresas.put(empresaActual.getId(), empresa);
			respuesta = Response.ok(empresa).build();
		} else {
			respuesta = Response.notModified().build();
		}

		return respuesta;
	}
}

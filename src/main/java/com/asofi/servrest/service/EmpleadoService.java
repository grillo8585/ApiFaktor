package com.asofi.servrest.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.asofi.servrest.entity.Empleado;

public interface EmpleadoService {
	
	public Iterable<Empleado> findAll();
	
	public Page<Empleado> findAll(Pageable pageable);
	
	public Optional<Empleado> findByID(Long id);
	
	public Empleado save(Empleado empleado);
	
	public void deteleById(Long id);

}

package com.asofi.servrest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asofi.servrest.entity.Empleado;
import com.asofi.servrest.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceimpl implements EmpleadoService{

	@Autowired 
	private EmpleadoRepository empleadosrepository;
	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Iterable<Empleado> findAll() {
		// TODO Auto-generated method stub
		return empleadosrepository.findAll();
	}

	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Page<Empleado> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return empleadosrepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Optional<Empleado> findByID(Long id) {
		// TODO Auto-generated method stub
		return empleadosrepository.findById(id);
	}

	@Override
	@Transactional
	public Empleado save(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadosrepository.save(empleado);
	}

	@Override
	@Transactional
	public void deteleById(Long id) {
		// TODO Auto-generated method stub
		empleadosrepository.deleteById(id);
	}

}

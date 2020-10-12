package com.asofi.servrest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asofi.servrest.entity.Proyectos;
import com.asofi.servrest.repository.ProyectosRepository;

@Service
public class ProyectosServiceimpl implements ProyectosService{

	@Autowired 
	private ProyectosRepository Proyectosrepository;
	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Iterable<Proyectos> findAll() {
		// TODO Auto-generated method stub
		return Proyectosrepository.findAll();
	}

	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Page<Proyectos> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return Proyectosrepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Optional<Proyectos> findByID(Long id) {
		// TODO Auto-generated method stub
		return Proyectosrepository.findById(id);
	}

	@Override
	@Transactional
	public Proyectos save(Proyectos proyecto) {
		// TODO Auto-generated method stub
		return Proyectosrepository.save(proyecto);
	}

	@Override
	@Transactional
	public void deteleById(Long id) {
		// TODO Auto-generated method stub
		Proyectosrepository.deleteById(id);
	}

}

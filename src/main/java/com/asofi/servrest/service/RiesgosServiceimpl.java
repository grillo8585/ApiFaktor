package com.asofi.servrest.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asofi.servrest.entity.Riesgos;
import com.asofi.servrest.repository.RiesgosRepository;

@Service
public class RiesgosServiceimpl implements RiesgosService{
	@PersistenceContext
	EntityManager em;
	@Autowired 
	private RiesgosRepository Riesgosrepository;
	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Iterable<Riesgos> findAll() {
		// TODO Auto-generated method stub
		return Riesgosrepository.findAll();
	}

	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Page<Riesgos> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return Riesgosrepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Optional<Riesgos> findByID(Long id) {
		// TODO Auto-generated method stub
		return Riesgosrepository.findById(id);
	}

	@Override
	@Transactional
	public Riesgos save(Riesgos riesgo) {
		// TODO Auto-generated method stub
		return Riesgosrepository.save(riesgo);
	}

	@Override
	@Transactional
	public void deteleById(Long id) {
		// TODO Auto-generated method stub
		Riesgosrepository.deleteById(id);
	}

}

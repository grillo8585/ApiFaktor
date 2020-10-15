package com.asofi.servrest.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asofi.servrest.entity.Empresas;
import com.asofi.servrest.entity.Riesgos;
import com.asofi.servrest.repository.EmpresasRepository;
import com.asofi.servrest.repository.RiesgosRepository;

@Service
public class EmpresasServiceimpl implements EmpresasService{
	@PersistenceContext
	EntityManager em;
	@Autowired 
	private EmpresasRepository empresasrepository;
	@Autowired 
	private RiesgosRepository riesgosrepository;
	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Iterable<Empresas> findAll() {
		// TODO Auto-generated method stub
		return empresasrepository.findAll();
	}

	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Page<Empresas> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return empresasrepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Optional<Empresas> findByID(Long id) {
		// TODO Auto-generated method stub
		return empresasrepository.findById(id);
	}

	@Override
	@Transactional
	public Empresas save(Empresas empresa) {
		// TODO Auto-generated method stub
		return empresasrepository.save(empresa);
	}

	@Override
	@Transactional
	public void deteleById(Long id) {
		// TODO Auto-generated method stub
		empresasrepository.deleteById(id);
	}

	@Override
	@Transactional
	public List<Riesgos> addRiesgos(Riesgos riesgo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Riesgos> getRiesgosById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Riesgos> getRiesgos() {
		// TODO Auto-generated method stub
		return null;
	}

}

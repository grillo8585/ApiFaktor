package com.asofi.servrest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asofi.servrest.entity.Empresas;
import com.asofi.servrest.repository.EmpresasRepository;

@Service
public class EmpresasServiceimpl implements EmpresasService{

	@Autowired 
	private EmpresasRepository empresasrepository;
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

}

package com.asofi.servrest.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.asofi.servrest.entity.Empresas;

public interface EmpresasService {
	
	public Iterable<Empresas> findAll();
	
	public Page<Empresas> findAll(Pageable pageable);
	
	public Optional<Empresas> findByID(Long id);
	
	public Empresas save(Empresas empresa);
	
	public void deteleById(Long id);

}

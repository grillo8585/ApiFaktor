package com.asofi.servrest.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.asofi.servrest.entity.Riesgos;

public interface RiesgosService {
	
	public Iterable<Riesgos> findAll();
	
	public Page<Riesgos> findAll(Pageable pageable);
	
	public Optional<Riesgos> findByID(Long id);
	
	public Riesgos save(Riesgos riesgo);
	
	public void deteleById(Long id);

}

package com.asofi.servrest.service;

import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.asofi.servrest.entity.Empresas;
import com.asofi.servrest.entity.Riesgos;

public interface EmpresasService {
	
	public Iterable<Empresas> findAll();
	
	public Page<Empresas> findAll(Pageable pageable);
	
	public Optional<Empresas> findByID(Long id);
	
	public List<Riesgos> addRiesgos(Riesgos riesgo);
	public List<Riesgos> getRiesgosById(Long id);
	public List<Riesgos> getRiesgos();
	public Empresas save(Empresas empresa);
	
	public List<Empresas> save(List<Empresas> empresas);
	
	public void deteleById(Long id);

}

package com.asofi.servrest.service;

import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;

import com.asofi.servrest.entity.Empresa;
import com.asofi.servrest.entity.Riesgo;

import org.springframework.data.domain.Sort;

import utils.PagingResponse;

public interface EmpresaService {
	
	public Iterable<Empresa> findAll();
	
	public Page<Empresa> findAll(Pageable pageable);
	
	public Optional<Empresa> findByID(Long id);
	
	public List<Riesgo> addRiesgos(Riesgo riesgo);
	public List<Riesgo> getRiesgosById(Long id);
	public List<Riesgo> getRiesgos();
	public Empresa save(Empresa empresa);
	
	public List<Empresa> save(List<Empresa> empresas);
	
	public void deteleById(Long id);
    public PagingResponse get(Specification<Empresa> spec, HttpHeaders headers, Sort sort);


}

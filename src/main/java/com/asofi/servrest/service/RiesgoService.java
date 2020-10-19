package com.asofi.servrest.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;

import com.asofi.servrest.entity.Riesgo;

import utils.PagingResponse;

public interface RiesgoService {
	
	public Iterable<Riesgo> findAll();
	
	public Page<Riesgo> findAll(Pageable pageable);
	
	public Optional<Riesgo> findByID(Long id);
	
	public Riesgo save(Riesgo riesgo);
	
	public void deteleById(Long id);
	public PagingResponse get(Specification<Riesgo> spec, HttpHeaders headers, Sort sort);

}

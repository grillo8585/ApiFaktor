package com.asofi.servrest.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asofi.servrest.entity.Empresa;
import com.asofi.servrest.entity.Riesgo;
import com.asofi.servrest.repository.EmpresasRepository;
import com.asofi.servrest.repository.RiesgosRepository;

import org.springframework.data.jpa.domain.Specification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import utils.PagingHeaders;
import utils.PagingResponse;

@Service
public class EmpresaServiceimpl implements EmpresaService{
	@PersistenceContext
	EntityManager em;
	@Autowired 
	private EmpresasRepository empresasrepository;
	@Autowired 
	private RiesgosRepository riesgosrepository;
	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Iterable<Empresa> findAll() {
		// TODO Auto-generated method stub
		return empresasrepository.findAll();
	}

	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Page<Empresa> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return empresasrepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Optional<Empresa> findByID(Long id) {
		// TODO Auto-generated method stub
		return empresasrepository.findById(id);
	}

	@Override
	@Transactional
	public Empresa save(Empresa empresa) {
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
	public List<Riesgo> addRiesgos(Riesgo riesgo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Riesgo> getRiesgosById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Riesgo> getRiesgos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empresa> save(List<Empresa> empresas) {
		// TODO Auto-generated method stub
		return empresasrepository.saveAll(empresas);
	}

	@Override
	public PagingResponse get(Specification<Empresa> spec, HttpHeaders headers, Sort sort) {
		 
		        if (isRequestPaged(headers)) {
		            return get(spec, buildPageRequest(headers, sort));
		        } else {
		            List<Empresa> entities = get(spec, sort);
		            return new PagingResponse((long) entities.size(), 0L, 0L, 0L, 0L, entities);
		        }
		 
	}
	
	  private boolean isRequestPaged(HttpHeaders headers) {
	        return headers.containsKey(PagingHeaders.PAGE_NUMBER.getName()) && headers.containsKey(PagingHeaders.PAGE_SIZE.getName());
	    }
	  
	    private Pageable buildPageRequest(HttpHeaders headers, Sort sort) {
	        int page = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE_NUMBER.getName())).get(0));
	        int size = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE_SIZE.getName())).get(0));
	        return PageRequest.of(page, size, sort);
	    }
	    
	    public PagingResponse get(Specification<Empresa> spec, Pageable pageable) {
	        Page<Empresa> page = empresasrepository.findAll(spec, pageable);
	        List<Empresa> content = page.getContent();
	        return new PagingResponse(page.getTotalElements(), (long) page.getNumber(), (long) page.getNumberOfElements(), pageable.getOffset(), (long) page.getTotalPages(), content);
	    }
	    
	    public List<Empresa> get(Specification<Empresa> spec, Sort sort) {
	        return empresasrepository.findAll(spec, sort);
	    }
}

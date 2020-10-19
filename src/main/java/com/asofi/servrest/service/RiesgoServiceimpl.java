package com.asofi.servrest.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asofi.servrest.entity.Empresa;
import com.asofi.servrest.entity.Riesgo;
import com.asofi.servrest.repository.RiesgosRepository;

import utils.PagingHeaders;
import utils.PagingResponse;

@Service
public class RiesgoServiceimpl implements RiesgoService{
	@PersistenceContext
	EntityManager em;
	@Autowired 
	private RiesgosRepository riesgosrepository;
	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Iterable<Riesgo> findAll() {
		// TODO Auto-generated method stub
		return riesgosrepository.findAll();
	}

	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Page<Riesgo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return riesgosrepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Optional<Riesgo> findByID(Long id) {
		// TODO Auto-generated method stub
		return riesgosrepository.findById(id);
	}

	@Override
	@Transactional
	public Riesgo save(Riesgo riesgo) {
		// TODO Auto-generated method stub
		return riesgosrepository.save(riesgo);
	}

	@Override
	@Transactional
	public void deteleById(Long id) {
		// TODO Auto-generated method stub
		riesgosrepository.deleteById(id);
	}
	
	@Override
	public PagingResponse get(Specification<Riesgo> spec, HttpHeaders headers, Sort sort) {
		 
		        if (isRequestPaged(headers)) {
		            return get(spec, buildPageRequest(headers, sort));
		        } else {
		            List<Riesgo> entities = get(spec, sort);
		            return new PagingResponse((long) entities.size(), 0L, 0L, 0L, 0L, entities,1);
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
	    
	    public PagingResponse get(Specification<Riesgo> spec, Pageable pageable) {
	        Page<Riesgo> page = riesgosrepository.findAll(spec, pageable);
	        List<Riesgo> content = page.getContent();
	        return new PagingResponse(page.getTotalElements(), (long) page.getNumber(), (long) page.getNumberOfElements(), pageable.getOffset(), (long) page.getTotalPages(), content, 1) ;
	    }
	    
	    public List<Riesgo> get(Specification<Riesgo> spec, Sort sort) {
	        return riesgosrepository.findAll(spec, sort);
	    }

}

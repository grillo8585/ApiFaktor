package com.asofi.servrest.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asofi.servrest.entity.Proyecto;
import com.asofi.servrest.repository.ProyectosRepository;

@Service
public class ProyectoServiceimpl implements ProyectoService{
	@PersistenceContext
	EntityManager em;
	@Autowired 
	private ProyectosRepository Proyectosrepository;
	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Iterable<Proyecto> findAll() {
		// TODO Auto-generated method stub
		return Proyectosrepository.findAll();
	}

	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Page<Proyecto> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return Proyectosrepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true) // Solo lectura , no cambia nada en la base de datos
	public Optional<Proyecto> findByID(Long id) {
		// TODO Auto-generated method stub
		return Proyectosrepository.findById(id);
	}

	@Override
	@Transactional
	public Proyecto save(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return Proyectosrepository.save(proyecto);
	}

	@Override
	@Transactional
	public void deteleById(Long id) {
		// TODO Auto-generated method stub
		Proyectosrepository.deleteById(id);
	}

	@Override
	public Optional<Proyecto> findByIDEmpresa(Long id) {
		//JPQL y HQL
		String jpql = "SELECT p FROM Proyecto p WHERE p.empresa_p.id=:empresa_id";
		Query query ;
		query = em.createQuery(jpql);	
		query.setParameter("empresa_id", id);
		
		Proyecto proyecto = (Proyecto) query.getSingleResult();
		

		return Optional.of(proyecto); 
		
	}

}

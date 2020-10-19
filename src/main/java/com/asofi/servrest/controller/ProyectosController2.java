package com.asofi.servrest.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asofi.servrest.entity.Empresa;
import com.asofi.servrest.entity.Proyecto;
import com.asofi.servrest.entity.Reporte;
import com.asofi.servrest.entity.Riesgo;
import com.asofi.servrest.service.EmpresaService;
import com.asofi.servrest.service.ProyectoService;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectosController2 {

	@Autowired //Realizamos la inyección de dependencias  
	private ProyectoService proyectosServices;
	@Autowired //Realizamos la inyección de dependencias  
	private EmpresaService empresasServices;
	
	//Crear proyecto
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Proyecto proyecto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(proyectosServices.save(proyecto));
	}
	
	// Leer una proyecto
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long Idproyecto){
		Optional<Proyecto> oproyectos = proyectosServices.findByID(Idproyecto);
		//Validamos que haya encontrado la proyecto
		if(!oproyectos.isPresent()) {
			//Devolvemos que no ha encontrado la proyecto
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oproyectos);
	}
	// Leer empresa de proyecto
    @GetMapping("/{id}/empresas")
    public ResponseEntity<?> read_empresas(@PathVariable(value = "id") Long Idproyecto){
			Optional<Proyecto> oproyectos = proyectosServices.findByID(Idproyecto);
			//Validamos que haya encontrado la proyecto
			if(!oproyectos.isPresent()) {
				//Devolvemos que no ha encontrado la proyecto
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok(oproyectos.get().getEmpresa());
		}
	

	// Leer empresa de proyecto
    @GetMapping("/{id}/empresas/{ide}")
    public ResponseEntity<?> read_empresas(@PathVariable(value = "id") Long Idproyecto,@PathVariable(value = "ide") Long Idempresa){
			Optional<Proyecto> oproyectos = proyectosServices.findByID(Idproyecto);
			//Validamos que haya encontrado la proyecto
			if(!oproyectos.isPresent()) {
				//Devolvemos que no ha encontrado la proyecto
				return ResponseEntity.notFound().build();
			}
			Optional<Empresa> oempresas = empresasServices.findByID(Idempresa);
			//Validamos que haya encontrado la proyecto
			if(!oempresas.isPresent()) {
				//Devolvemos que no ha encontrado la proyecto
				return ResponseEntity.notFound().build();
			}
			//Validamos que la empresa encontrada sea la misma del proyecto
			if(!(oproyectos.get().getEmpresa().getId() == Idempresa) ) {
				//Devolvemos que no ha encontrado la proyecto
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(oproyectos.get().getEmpresa());
		}

	// Leer empresa de proyecto
    @GetMapping("/empresas/{ide}")
    public ResponseEntity<?> read_empresas_p(@PathVariable(value = "ide") Long Idempresa){
    	Optional<Proyecto> oProyectos = proyectosServices.findByIDEmpresa(Idempresa);
		//Validamos que haya encontrado el proyecto
		if(!oProyectos.isPresent()) {
			//Devolvemos que no ha encontrado la empresa
			return ResponseEntity.notFound().build();
			}
		   return ResponseEntity.ok().body(oProyectos);
		}
   
    
	//Actualizar una proyecto
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Proyecto proyectoDetails,  @PathVariable(value = "id") Long Idproyecto){
		Optional<Proyecto> oproyectos = proyectosServices.findByID(Idproyecto);
		//Validamos que haya encontrado la proyecto
		if(!oproyectos.isPresent()) {
			//Devolvemos que no ha encontrado la proyecto
			return ResponseEntity.notFound().build();
		}
		
		//Actualizamos los campos
		oproyectos.get().setNombre(proyectoDetails.getNombre());
		oproyectos.get().setEmpresa(proyectoDetails.getEmpresa());
		oproyectos.get().setDescripcion(proyectoDetails.getDescripcion());
		return ResponseEntity.status(HttpStatus.CREATED).body(proyectosServices.save(oproyectos.get()));
		
	}
	//Borrar una proyecto
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long Idproyecto){
		Optional<Proyecto> oproyectos = proyectosServices.findByID(Idproyecto);
		//Validamos que haya encontrado la proyecto
		if(!oproyectos.isPresent()) {
			//Devolvemos que no ha encontrado la proyecto
			return ResponseEntity.notFound().build();
		}
		//Borramos el usuario
		proyectosServices.deteleById(Idproyecto);
		//Devolvemos rspuesta con código 200 = OK
		return ResponseEntity.ok().build();
	}
	
	//Leer Todas las proyectos
	@GetMapping
	public List<Proyecto> readAll(){
		//Utilizamos Streamsupport Api Java 8
		
		List<Proyecto> proyectos = StreamSupport // Usamos streamsupport que hereda de Object 
				.stream(proyectosServices.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return proyectos;
	}
	

	//Consultar Riesgo de líquidez
    @GetMapping("/empresas/{ide}/liquidez")
    public ResponseEntity<?> read_riesgo(@PathVariable(value = "ide") Long Idempresa){
    	Optional<Proyecto> oProyectos = proyectosServices.findByIDEmpresa(Idempresa);
		//Validamos que haya encontrado el proyecto
		if(!oProyectos.isPresent()) {
			//Devolvemos que no ha encontrado la empresa
			return ResponseEntity.notFound().build();
			}
		Optional<Empresa> oEmpresas = empresasServices.findByID(Idempresa);
		//Validamos que haya encontrado la empresa
		if(!oEmpresas.isPresent()) {

			//Devolvemos que no ha encontrado la empresa
			return ResponseEntity.notFound().build();

		}
			Reporte reporte = generar_calculo(oEmpresas.get());
			return ResponseEntity.ok().body(reporte);
		}
    
	
	//Consultar Reportes
    @GetMapping("/empresas/{ide}/reportes")
    @Produces({"text/plain", "application/json"})
    public ResponseEntity<Resource> read_reporte(@PathVariable(value = "ide") Long Idempresa){
    	Optional<Proyecto> oProyectos = proyectosServices.findByIDEmpresa(Idempresa);
    	
    	
		//Validamos que haya encontrado el proyecto
		if(!oProyectos.isPresent()) {
			//Devolvemos que no ha encontrado la empresa
			//return ResponseEntity.notFound().build();
			return null;
			}
		
		Optional<Empresa> oEmpresas = empresasServices.findByID(Idempresa);
		//Validamos que haya encontrado la empresa
		if(!oEmpresas.isPresent()) {
			//Devolvemos que no ha encontrado la empresa
			//return response.notFound().build();
		}
		 Reporte reporte = generar_calculo(oEmpresas.get());
		 StringBuilder sbuilder = new StringBuilder();
	     Class<?> c = oEmpresas.get().getClass();
	     Field[] fields = c.getDeclaredFields();
	     Method[] methods = c.getDeclaredMethods();
	     Map<String, Object> temp = new HashMap<String, Object>();
	     
	     sbuilder.append("Nombre ");
	     sbuilder.append(oEmpresas.get().getNombre());
	     sbuilder.append("\n");
	     sbuilder.append("Reportes \n");
	     sbuilder.append("Riesgo de liquidez ");
	     sbuilder.append("\n");
	     for(String s:reporte.getCalculo()) {
	    	 sbuilder.append(s);
	    	 sbuilder.append("\n");	 
	     }
	     
//	     for( Method method : methods ){
//	          try {
//	        	  sbuilder.append(method.getName());
//	        	  try {
//					sbuilder.append(method.invoke(oEmpresas.get(), null));
//				} catch (InvocationTargetException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	        	  
//	        	  
//	              // temp.put(field.getName().toString(), field.get(oEmpresas.get()));
//	          } catch (IllegalArgumentException e1) {
//	          } catch (IllegalAccessException e1) {
//	          }
//	     } 
//	     for( Field field : fields ){
//	          try {
//	        	  sbuilder.append(field.getName().toString());
//	        	  
//	        	  sbuilder.append(field.get(oEmpresas.get()));
//	              // temp.put(field.getName().toString(), field.get(oEmpresas.get()));
//	          } catch (IllegalArgumentException e1) {
//	          } catch (IllegalAccessException e1) {
//	          }
//	     } 
		//Resource resource = new ByteArrayResource(oEmpresas.toString().getBytes());
		Resource resource = new ByteArrayResource(sbuilder.toString().getBytes());
		String file = "Reportes"+oEmpresas.get().getNombre()+"txt";
	    return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file + "\"")
                .body(resource);
		
		}
	  public Reporte generar_calculo(Empresa emp) {
		  Reporte reporte = new Reporte();
			reporte.setId(emp.getId());
			reporte.setNombre("liquidez" + emp.getNombre());
			List<String> calculo = new ArrayList<>();
			for( Riesgo r : emp.getL_riesgos() )
			{
				if (r.getId()%2==0)
				    //pasará
					calculo.add("Riesgo "+r.getNombre()+" Probabilidad:"+ "Pasará");
				else
					//No pasará
				calculo.add("Riesgo "+r.getNombre()+" Probabilidad:"+ "No Pasará");
				
			}
			   reporte.setCalculo(calculo);
		  
		  return reporte;
		  
	  } 
 }


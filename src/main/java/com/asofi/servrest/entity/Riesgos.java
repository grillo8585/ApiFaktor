package com.asofi.servrest.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name="riesgos")
@XmlRootElement(name="riesgos")
public class Riesgos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7738684523315526844L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String nombre;
	
    //@ManyToOne
    //@JoinColumn(name = "empresas_id")
	@ManyToMany(mappedBy = "l_riesgos")
    private List<Empresas> l_empresa;
	
	@PreRemove
	public void removeRiesgosFromEmpresas() {
	    for (Empresas emp : l_empresa) {
	    	emp.getL_riesgos().remove(this);
	    }
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

package com.farmacia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="medicamento")
@Table(name="medicamento")
public class Medicamento {
	
	@Id
	@Column(name="id_medicamento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre_medicamento", length=100)
	private String nombre;
	
	@Column(name="url_imagen", length=250)
	private String url;
	
	public Medicamento() {
	
	}

	public Medicamento(Integer id, String nombre, String url) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.url = url;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	

}

package com.farmacia.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="farmacia")
@Table(name="farmacia")
public class Farmacia {

	@Id
	@Column(name="id_farmacia")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre_farmacia", length=100)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="id_medicamento")
	private Medicamento medicamento;
	
	@Column(name="precio", precision=5, scale=2)
	private BigDecimal precio;
	
	public Farmacia() {
		// TODO Auto-generated constructor stub
	}

	public Farmacia(Integer id, String nombre, BigDecimal precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
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

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
}

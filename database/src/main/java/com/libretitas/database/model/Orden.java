package com.libretitas.database.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO
@Entity
@Table(name = "orden")
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idOrden", unique=true, nullable=false)
	private Long idOrden;
	@Column(nullable=false)
	private LocalDate fecha;
	@Column(nullable=false)
	private Double totalOrden;
	@Column(nullable=false)
	private Integer Usuario_idUsuario;
	private static long total=0;
	
	public Orden(LocalDate fecha, Double totalOrden, Integer Usuario_idUsuario) {
		super();
		this.fecha = fecha;
		this.totalOrden = totalOrden;
		this.Usuario_idUsuario = Usuario_idUsuario;
//		Orden.total++;
//		this.id=total;
		
	}//constructor
	
	public Orden() {
//		Orden.total++;
//		this.id=total;
	}// Constructor vacío

	public LocalDate getFecha() {
		return fecha;
	}//GET FECHA

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}//SET FECHA

	public Double getTotalOrden() {
		return totalOrden;
	}//GET TOTAL

	public void setTotalOrden(Double totalOrden) {
		this.totalOrden = totalOrden;
	}//SET TOTAL

	public Integer getUsuario_idUsuario() {
		return Usuario_idUsuario;
	}//GET ID USUARIO

	public void setUsuario_idUsuario(Integer Usuario_idUsuario) {
		this.Usuario_idUsuario = Usuario_idUsuario;
	}//SET ID USUARIO

	public Long getId() {
		return idOrden;
	}//GET ID



	@Override
	public String toString() {
		return "Orden [id=" + idOrden + ", fecha=" + fecha + ", totalOrden=" + totalOrden + ", idUsuario=" + Usuario_idUsuario + "]";
	}// TO STRING
		

}//class Orden
package com.libretitas.database.model;


import java.time.LocalDate;

public class Orden {
	private Long id;
	private LocalDate fecha;
	private Double totalOrden;
	private Integer idUsuario;
	private static long total=0;
	
	public Orden(LocalDate fecha, Double totalOrden, Integer idUsuario) {
		super();
		this.fecha = fecha;
		this.totalOrden = totalOrden;
		this.idUsuario = idUsuario;
		Orden.total++;
		this.id=total;
		
	}//constructor
	
	
	
	public Orden() {
		Orden.total++;
		this.id=total;
	}// Constructor vacio



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

	public Integer getIdUsuario() {
		return idUsuario;
	}//GET ID USUARIO

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}//SET ID USUARIO


	public Long getId() {
		return id;
	}//GET ID



	@Override
	public String toString() {
		return "Orden [id=" + id + ", fecha=" + fecha + ", totalOrden=" + totalOrden + ", idUsuario=" + idUsuario + "]";
	}// TO STRING
		

}//class Orden
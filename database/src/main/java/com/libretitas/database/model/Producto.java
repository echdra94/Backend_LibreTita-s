package com.libretitas.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO

@Entity
@Table(name="producto")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idProducto", unique=true, nullable=false)
	private Long idProducto;
	@Column(nullable=false)
	private String nombreProducto;
	private String descripcion;
	@Column(nullable=false)
	private Double precio;
	private String imagen;
	//private Long existencias;
	
	public Producto(String nombreProducto, String descripcion, Double precio, String imagen) {
		super();
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		//this.existencias = existencias;
		//Producto.total++;
		//this.id=total;
	}// Constructor

	public Producto() {
		//Producto.total++;
		//this.id=total;
	}// Constructor vacio

	public String getNombreProducto() {
		return nombreProducto;
	}// GET NOMBRE

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}//SET NOMBRE

	public String getDescripcion() {
		return descripcion;
	}// GET DESCRIPCION

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//SET DESCRIPCION

	public String getImagen() {
		return imagen;
	}// GET IMAGE

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}// SET IMAGE

	//public Long getExistencias() {
	//	return existencias;
	//}// GET EXISTENCIAS

	//public void setExistencias(Long existencias) {
	//	this.existencias = existencias;
	//}// SET EXISTENCIAS

	public Double getPrecio() {
		return precio;
	}// GET PRECIO

	public void setPrecio(Double precio) {
		this.precio = precio;
	}// SET PRECIO

	public Long getId() {
		return idProducto;
	}// GET ID

	@Override
	public String toString() {
		return "Producto [id=" + idProducto + ", nombreProducto=" + nombreProducto + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", precio=" + precio + "]";
	}// TO STRING
	
}// class Producto

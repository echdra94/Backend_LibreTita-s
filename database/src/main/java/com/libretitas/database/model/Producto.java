package com.libretitas.database.model;

public class Producto {
	private Long id;
	private String nombreProducto;
	private String descripcion;
	private Double precio;
	private String imagen;
	private Integer existencias;
	private static long total =0;
	
	public Producto(String nombreProducto, String descripcion, Double precio, String imagen, Integer existencias) {
		super();
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		this.existencias = existencias;
		Producto.total++;
		this.id=total;
	}// Constructor

	public Producto() {
		Producto.total++;
		this.id=total;
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

	public Integer getExistencias() {
		return existencias;
	}// GET EXISTENCIAS

	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}// SET EXISTENCIAS

	public Double getPrecio() {
		return precio;
	}// GET PRECIO

	public void setPrecio(Double precio) {
		this.precio = precio;
	}// SET PRECIO

	public Long getId() {
		return id;
	}// GET ID

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombreProducto=" + nombreProducto + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", existencias=" + existencias + ", precio=" + precio + "]";
	}// TO STRING
	
}// class Producto

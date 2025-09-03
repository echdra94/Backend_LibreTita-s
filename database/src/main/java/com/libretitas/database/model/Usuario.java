package com.libretitas.database.model;

public class Usuario {
	private Long id;
	private String nombre;
	private String apellido;
	private String correo;
	private String contraseña;
	private String telefono;
	private Boolean promociones;
	private static long total=0;
	
	public Usuario(String nombre, String apellido, String correo, String contraseña, String telefono,
			Boolean promociones) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contraseña = contraseña;
		this.telefono = telefono;
		this.promociones = promociones;
		Usuario.total++;
		this.id=total;
	}//constructor parámetros

	public Usuario() {
		Usuario.total++;
		this.id=total;
	}//constructor vacío

	public String getNombre() {
		return nombre;
	}//GET NOMBRE

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//SET NOMBRE

	public String getApellido() {
		return apellido;
	}//GET APELLIDO

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}//SET APELLIDO

	public String getCorreo() {
		return correo;
	}//GET CORREO

	public void setCorreo(String correo) {
		this.correo = correo;
	}//SET CORREO

	public String getContraseña() {
		return contraseña;
	}//GET CONTRASEÑA

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}//SET CONSTRASEÑA

	public String getTelefono() {
		return telefono;
	}//GET TELEFONO

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}//SET TELEFONO

	public Boolean getPromociones() {
		return promociones;
	}//GET PROMOCIONES

	public void setPromociones(Boolean promociones) {
		this.promociones = promociones;
	}//SET PROMOCIONES

	public Long getId() {
		return id;
	}//GET ID

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", telefono=" + telefono + ", promociones=" + promociones + "]";
	}//To String
	
	
	
}//class Usuario

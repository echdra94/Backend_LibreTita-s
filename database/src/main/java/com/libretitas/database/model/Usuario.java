package com.libretitas.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUsuario", unique=true, nullable=false)
	private Long idUsuario;
	private String nombre;
	private String apellido;
	private String correo;
	@Column(nullable=false)
	private String contraseña;
	private String telefono;
	private static long total=0;
	
	public Usuario(String nombre, String apellido, String correo, String contraseña, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contraseña = contraseña;
		this.telefono = telefono;
		//this.promociones = promociones;
		//Usuario.total++;
		//this.id=total;
	}//constructor parámetros

	public Usuario() {
		//Usuario.total++;
		//this.idUsuario=Usuario.total;
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

	//public Boolean getPromociones() {
	////	return promociones;
	//}//GET PROMOCIONES

	//public void setPromociones(Boolean promociones) {
	//	this.promociones = promociones;
	//}//SET PROMOCIONES

	public Long getId() {
		return idUsuario;
	}//GET ID

	@Override
	public String toString() {
		return "Usuario [id=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", telefono=" + telefono + "]";
	}//To String
	
	
	
}//class Usuario

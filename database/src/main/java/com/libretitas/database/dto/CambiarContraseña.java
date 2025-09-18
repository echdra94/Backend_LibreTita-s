package com.libretitas.database.dto;

public class CambiarContraseña {
	private String contraseña;
	private String ncontraseña;
	public CambiarContraseña(String contraseña, String ncontraseña) {
		super();
		this.contraseña=contraseña;
		this.ncontraseña=ncontraseña;
	}//constructor

	public CambiarContraseña() {}//constructor
	
	public String getContraseña() {
		return contraseña;
	}//getContraseña
	
	public void setContraseña(String contraseña) {
		this.contraseña=contraseña;
	}//setContraseña
	
	public String getNcontraseña() {
		return ncontraseña;
	}//	getNcontraseña
	
	public void setNcontraseña(String ncontraseña) {
		this.ncontraseña=ncontraseña;
	}//setNcontraseña

	@Override
	public String toString() {
		return "CambiarContraseña [contraseña=" + contraseña + ", ncontraseña=" + ncontraseña + "]";
	}//toString
		
	
}//class CambiarContraseña

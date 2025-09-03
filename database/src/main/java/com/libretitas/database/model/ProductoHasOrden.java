package com.libretitas.database.model;

public class ProductoHasOrden {
	private Long fkIdProduct;
	private Long fkIdOrden;
	private static long total=0;
	
	public ProductoHasOrden(Long fkIdProduct, Long fkIdOrden) {
		super();
		this.fkIdProduct = fkIdProduct;
		this.fkIdOrden = fkIdOrden;
		
	}//constructor 
	public ProductoHasOrden() {
		
	}//constructor vacio 
	public Long getFkIdProduct() {
		return fkIdProduct;
	}//getFkIdProduct
	public void setFkIdProduct(Long fkIdProduct) {
		this.fkIdProduct = fkIdProduct;
	}//setFkIdProduct
	public Long getFkIdOrden() {
		return fkIdOrden;
	}//getFkIdOrden
	public void setFkIdOrden(Long fkIdOrden) {
		this.fkIdOrden = fkIdOrden;
	}//setFkIdOrden
	@Override
	public String toString() {
		return "ProductoHasOrden [fkIdProduct=" + fkIdProduct + ", fkIdOrden=" + fkIdOrden + "]";
	}// to string
	
	
}//clas

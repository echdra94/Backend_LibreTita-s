package com.libretitas.database.model;

public class ProductoHasOrden {
	private Long id;
	private Integer fkIdProduct;
	private Integer fkIdOrden;
	private static long total=0;
	
	public ProductoHasOrden(Integer fkIdProduct, Integer fkIdOrden) {
		super();
		this.fkIdProduct = fkIdProduct;
		this.fkIdOrden = fkIdOrden;
		ProductoHasOrden.total++;
		this.id=total;
	}//constructor 
	
	public ProductoHasOrden() {
		ProductoHasOrden.total++;
		this.id=total;
	}//constructor vacio 
	
	public Integer getFkIdProduct() {
		return fkIdProduct;
	}//getFkIdProduct
	
	public void setFkIdProduct(Integer fkIdProduct) {
		this.fkIdProduct = fkIdProduct;
	}//setFkIdProduct
	
	public Integer getFkIdOrden() {
		return fkIdOrden;
	}//getFkIdOrden
	
	public void setFkIdOrden(Integer fkIdOrden) {
		this.fkIdOrden = fkIdOrden;
	}//setFkIdOrden
	
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ProductoHasOrden [id=" + id + ", fkIdProduct=" + fkIdProduct + ", fkIdOrden=" + fkIdOrden + "]";
	}

	
}//class

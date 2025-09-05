package com.libretitas.database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto_has_orden")
public class ProductoHasOrden {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer fkIdProduct;
	private Integer fkIdOrden;
	
	
	public ProductoHasOrden(Integer fkIdProduct, Integer fkIdOrden) {
		
		this.fkIdProduct = fkIdProduct;
		this.fkIdOrden = fkIdOrden;
	}//constructor 
	
	public ProductoHasOrden() {
		
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

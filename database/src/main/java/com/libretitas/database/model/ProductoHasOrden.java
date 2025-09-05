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
	private Long idProductoHasOrden;
	private Long fkIdProduct;
	private Long fkIdOrden;
	
	
	public ProductoHasOrden(Long fkIdProduct, Long fkIdOrden) {
		
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
	
	public Long getId() {
		return idProductoHasOrden;
	}

	@Override
	public String toString() {
		return "ProductoHasOrden [id=" + idProductoHasOrden + ", fkIdProduct=" + fkIdProduct + ", fkIdOrden=" + fkIdOrden + "]";
	}

	
}//class

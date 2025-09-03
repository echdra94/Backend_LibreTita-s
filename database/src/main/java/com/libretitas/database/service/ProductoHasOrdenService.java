package com.libretitas.database.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libretitas.database.model.Orden;
import com.libretitas.database.model.ProductoHasOrden;

@Service
public class ProductoHasOrdenService {
	private final ArrayList<ProductoHasOrden> lista = new ArrayList<ProductoHasOrden>();
	@Autowired
	public ProductoHasOrdenService() {
		//Integer fkIdProduct, Integer fkIdOrden
		lista.add(new ProductoHasOrden(1,1));
		lista.add(new ProductoHasOrden(2,2));
		lista.add(new ProductoHasOrden(4,2));
		lista.add(new ProductoHasOrden(3,3));
		lista.add(new ProductoHasOrden(7,4));
		lista.add(new ProductoHasOrden(7,4));
		lista.add(new ProductoHasOrden(8,4));
		lista.add(new ProductoHasOrden(8,5));
		lista.add(new ProductoHasOrden(8,5));
		lista.add(new ProductoHasOrden(7,5));
	}//constructor
	
	public List<ProductoHasOrden> getProdsHasOrdenes() {
		return lista;
	}//getProdsHasOrdenes

	public ProductoHasOrden getProdHasOrden(Long id) {
		ProductoHasOrden tmpPHO = null;
		for (ProductoHasOrden pho : lista) {
			if(pho.getId()==id) {
				tmpPHO=pho;
				break;
			}//if
		}// foreach
		return tmpPHO;
	}//getProdHasOrden

	public ProductoHasOrden deleteProdHasOrden(Long id) {
		ProductoHasOrden tmpPHO = null;
		for (ProductoHasOrden pho : lista) {
			if(pho.getId()==id) {
				tmpPHO=pho;
				lista.remove(pho);
				break;
			}//if
		}// foreach
		return tmpPHO;
	}//deleteProdHasOrden

	public ProductoHasOrden addProdHasOrden(ProductoHasOrden productoHasorden) {
		lista.add(productoHasorden);
		return productoHasorden;
	}//addProdHasOrden

	public ProductoHasOrden updateProdHasOrden(Long id, Integer fkIdProduct, Integer fkIdOrden) {
		ProductoHasOrden tmpPHO = null;
		for (ProductoHasOrden pho : lista) {
			if(pho.getId()==id) {
				if(fkIdProduct!=null) pho.setFkIdProduct(fkIdProduct);
				if(fkIdOrden!=null) pho.setFkIdOrden(fkIdOrden);
				tmpPHO=pho;
				break;
			}//if
		}// foreach
		return tmpPHO;
	}//updateProdHasOrden
	
	
	
}// PHO Service

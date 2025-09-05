package com.libretitas.database.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libretitas.database.model.Orden;
import com.libretitas.database.model.ProductoHasOrden;
import com.libretitas.database.repository.ProductoHasOrdenRepository;

@Service
public class ProductoHasOrdenService {
	
	private final ProductoHasOrdenRepository repository;
	@Autowired
	public ProductoHasOrdenService(ProductoHasOrdenRepository repository) {
		//Integer fkIdProduct, Integer fkIdOrden
		this.repository=repository;
	}//constructor
	
	public List<ProductoHasOrden> getProdsHasOrdenes() {
		return repository.findAll();
	}//getProdsHasOrdenes

	public ProductoHasOrden getProdHasOrden(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("No existe ProductoHasOrden con id [" + id + "]")
				);
	}//getProdHasOrden

	public ProductoHasOrden deleteProdHasOrden(Long id) {
		ProductoHasOrden tmp = getProdHasOrden(id);
		return tmp;
	}//deleteProdHasOrden

	public ProductoHasOrden addProdHasOrden(ProductoHasOrden productoHasOrden) {
		return repository.save(productoHasOrden);
	}//addProdHasOrden

	public ProductoHasOrden updateProdHasOrden(Long id, Integer fkIdProduct, Integer fkIdOrden) {
		ProductoHasOrden tmp = getProdHasOrden(id);
		if (fkIdProduct!=null) tmp.setFkIdProduct(fkIdProduct);
		if (fkIdOrden!=null) tmp.setFkIdOrden(fkIdOrden);
		return repository.save(tmp);
	}//updateProdHasOrden
	
	
	
}// PHO Service

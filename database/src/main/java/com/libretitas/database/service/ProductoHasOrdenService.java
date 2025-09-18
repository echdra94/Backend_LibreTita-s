package com.libretitas.database.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public ProductoHasOrden getProdHasOrden(Long idProductoHasOrden) {
		return repository.findById(idProductoHasOrden).orElseThrow(
				() -> new IllegalArgumentException("No existe ProductoHasOrden con id [" + idProductoHasOrden + "]")
				);
	}//getProdHasOrden

	public ProductoHasOrden deleteProdHasOrden(Long idProductoHasOrden) {
		ProductoHasOrden tmp = null;
		if (repository.existsById(idProductoHasOrden)) {
			tmp =  repository.findById(idProductoHasOrden).get();
			repository.deleteById(idProductoHasOrden);
		}//if
		return tmp;
	}//deleteProdHasOrden

	public ProductoHasOrden addProdHasOrden(ProductoHasOrden productoHasOrden) {
		return repository.save(productoHasOrden);
	}//addProdHasOrden

	public ProductoHasOrden updateProdHasOrden(Long id, Long fkIdProduct, Long fkIdOrden) {
		ProductoHasOrden tmp = getProdHasOrden(id);
		if (fkIdProduct!=null) tmp.setFkIdProduct(fkIdProduct);
		if (fkIdOrden!=null) tmp.setFkIdOrden(fkIdOrden);
		return repository.save(tmp);
	}//updateProdHasOrden
	
	
	
}// PHO Service

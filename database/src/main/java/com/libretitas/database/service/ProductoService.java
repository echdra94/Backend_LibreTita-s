package com.libretitas.database.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libretitas.database.model.Producto;
import com.libretitas.database.repository.ProductosRepository;

@Service
	public class ProductoService {
		private final ProductosRepository repository;
		@Autowired
		public ProductoService(ProductosRepository repository) {
		this.repository = repository;
	}// CONSTRUCTOR
	
	public List<Producto> getProducts() {
		return repository.findAll();
	}//getProducts
	
	public Producto getProduct(Long idProducto) {
		return repository.findById(idProducto).orElseThrow(
				()-> new IllegalArgumentException("El producto con el id["+ idProducto+ "] no existe")
				);
	}// getProduct
	
	public Producto deleteProduct(Long idProducto) {
		Producto tmpProd = null;
		if(repository.existsById(idProducto)) {
			tmpProd=repository.findById(idProducto).get();
			repository.deleteById(idProducto);
		}//if
		return tmpProd;
	}// deleteProduct
	
	public Producto addProduct(Producto producto) {
		Optional<Producto> prod =
				repository.findByNombreProducto(producto.getNombreProducto());
		if(prod.isEmpty()) {
			repository.save(producto);
		}//if
		else {
			producto=null;
		}
		return producto;
	}// addProduct
	
	public Producto updateProduct(Long idProducto, String nombreProducto, String descripcion, Double precio, String imagen) {
		Producto tmpProd = null;
		
		if(repository.existsById(idProducto)) {
			Producto prod = repository.findById(idProducto).get();
			if(nombreProducto!=null)prod.setNombreProducto(nombreProducto);
			if(descripcion!=null)prod.setDescripcion(descripcion);
			if(precio!=null)prod.setPrecio(precio);
			if(imagen!=null)prod.setImagen(imagen);
			//if(existencias!=null)prod.setExistencias(existencias);
			repository.save(prod);
			tmpProd=prod;
		}//if
		return tmpProd;
	}//updateProduct
	
	
	
}//class ProductoService

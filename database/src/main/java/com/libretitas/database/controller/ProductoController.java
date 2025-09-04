package com.libretitas.database.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.libretitas.database.model.Producto;
import com.libretitas.database.service.ProductoService;


@RestController
@RequestMapping(path="/api/productos/") // http://localhost:8080/api/productos/
public class ProductoController {
	private final ProductoService service;
	@Autowired
	public ProductoController(ProductoService service) {
		this.service=service;
	}// constructor
	
	//GET todos
	@GetMapping
	public List<Producto> getProductos(){
		return service.getProducts();
	}//getProductos
	
	//GET un elemento
	@GetMapping (path="{prodId}") // // http://localhost:8080/api/productos/1
	public Producto getProducto(@PathVariable ("prodId") Long idProducto) {
		return service.getProduct(idProducto);
	}//getProducto uno solo
	
	//DELETE
	@DeleteMapping (path="{prodId}") // http://localhost:8080/api/productos/1
	public Producto deleteProducto(@PathVariable ("prodId") Long idProducto) {
		return service.deleteProduct(idProducto);
	}// deleteProduct
	
	//POST
	@PostMapping 
	public Producto addProducto(@RequestBody Producto producto) {
		return service.addProduct(producto);
	}//add Producto
	
	//PUT
	@PutMapping (path="{prodId}") // http://localhost:8080/api/productos/1
	public Producto updateProducto(@PathVariable("prodId") Long id,
		@RequestParam (name="nombreProducto", required=false) String nombreProducto,
		@RequestParam (name="descripcion",required=false) String descripcion,
		@RequestParam (name="precio",required=false) Double precio,
		@RequestParam (name="imagen",required=false) String imagen,
		@RequestParam (name="existencias",required=false) Long existencias){
		return service.updateProduct(id, nombreProducto, descripcion, precio, imagen, existencias);
			
		}// updateProducto
	
}// class ProductoController

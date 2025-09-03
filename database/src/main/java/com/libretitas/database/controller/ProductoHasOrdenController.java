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

import com.libretitas.database.model.ProductoHasOrden;
import com.libretitas.database.service.ProductoHasOrdenService;


@RestController
@RequestMapping(path="/api/Producto_has_Orden/") //http://localhost:8080/api/Producto_has_Orden/
public class ProductoHasOrdenController {
	private  final ProductoHasOrdenService service;
	@Autowired
	public ProductoHasOrdenController(ProductoHasOrdenService service) {
		this.service = service;
	}//constructor
	
	//GET todos
	@GetMapping
	public List<ProductoHasOrden> getProdsHasOrdenes(){
		return service.getProdsHasOrdenes();
	}//getProdsHasOrdenes
	
	//GET uno
	@GetMapping(path="{ProductoHasOrdenId}") // http://localhost:8080/api/Producto_has_Orden/1
	public ProductoHasOrden getProdHasOrden(@PathVariable ("ProductoHasOrdenId")Long id) {
		return service.getProdHasOrden(id);
	}//getProdHasOrden
	
	//DELETE
	@DeleteMapping(path="{ProductoHasOrdenId}")
	public ProductoHasOrden deleteProdHasOrden (@PathVariable ("ProductoHasOrdenId")Long id) {
		return service.deleteProdHasOrden(id);
	}// deleteProdHasOrden
	
	//POST
	@PostMapping
	public ProductoHasOrden addProdHasOrden(@RequestBody ProductoHasOrden productoHasorden) {
		return service.addProdHasOrden(productoHasorden);
	}//addProdHasOrden
	
	//PUT
	@PutMapping(path="{ProductoHasOrdenId}") // http://localhost:8080/api/Producto_has_Orden/1
	public ProductoHasOrden updateProdHasOrden(@PathVariable("ProductoHasOrdenId")Long id,
			@RequestParam (name="fkIdProduct", required=false)Integer fkIdProduct ,
			@RequestParam (name="fkIdOrden", required=false)Integer fkIdOrden) {
		return service.updateProdHasOrden(id,fkIdProduct,fkIdOrden);
	}//updateProdHasOrden
}// PHOController

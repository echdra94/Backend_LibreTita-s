package com.libretitas.database.controller;

import java.time.LocalDate;
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
import com.libretitas.database.model.Orden;
import com.libretitas.database.service.OrdenService;

@RestController
@RequestMapping(path="/api/ordenes/") //http://localhost:8080/api/ordenes/
public class OrdenController {
	private final OrdenService service;
	@Autowired
	public OrdenController(OrdenService service) {
		this.service = service;
	}//constructor
	
	//GET todos
	@GetMapping
	public List<Orden> getOrdenes() {
		return service.getOrdenes();
	}//getOrdenes
	
	//GET un elemento
	@GetMapping(path="{ordenId}") // http://localhost:8080/api/ordenes/1
	public Orden getOrden(@PathVariable ("ordenId") Long idOrden) {
		return service.getOrden(idOrden);
	}//getOrden solo una
	
	//DELETE
	@DeleteMapping(path="{ordenId}") // http://localhost:8080/api/ordenes/1
	public Orden deleteOrden(@PathVariable("ordenId") Long idOrden) {
		return service.deleteOrden(idOrden);
	}//deleteOrden
	
	//POST
	@PostMapping
	public Orden addOrden(@RequestBody Orden orden) {
		return service.addOrden(orden);
	}//add Orden
	
	//PUT 
	@PutMapping (path= "{ordenId}") //http://localhost:8080/api/ordenes/1
	public Orden updateOrden(@PathVariable("ordenId") Long id,
			@RequestParam (name="fecha", required=false) LocalDate fecha,
			@RequestParam (name="totalOrden",required=false) Double totalOrden,
			@RequestParam (name="idUsuario",required=false) Integer Usuario_idUsuario){
			return service.updateOrden(id, fecha, totalOrden, Usuario_idUsuario);
				
			}// updateOrden
	
	
	
}//class OrdenController

package com.libretitas.database.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;
import com.libretitas.database.model.Orden;
import com.libretitas.database.repository.OrdenRepository;


@Service
public class OrdenService {
	private final OrdenRepository repository;
	@Autowired
	public OrdenService(OrdenRepository repository) {
       this.repository = repository;
	}//constructor
	
	public List<Orden> getOrdenes(){
		return repository.findAll();
	}//getOrdenes
	
	public Orden getOrden(Long idOrden) {
		Orden tmpOrd = null;
		return repository.findById(idOrden).orElseThrow(
		()-> new IllegalArgumentException("El producto con el id [" + idOrden + "] no existe")		
				);
	}// getOrden
	
	
	public Orden deleteOrden(Long idOrden) {
		Orden tmpOrd = null;
		if (repository.existsById(idOrden)) {
			tmpOrd =  repository.findById(idOrden).get();
			repository.deleteById(idOrden);
		}//if
		return tmpOrd;
	}// deleteOrden
	
	public Orden addOrden(Orden orden) {
		return repository.save(orden);
	}// addOrden
	
	public Orden updateOrden(Long idOrden, LocalDate fecha, Double totalOrden, Long Usuario_idUsuario) {
		Orden tmpOrd=null;
		
			if(repository.existsById(idOrden)) {
				Orden ord = repository.findById(idOrden).get();
				if(fecha!=null) ord.setFecha(fecha);
				if(totalOrden!=null) ord.setTotalOrden(totalOrden);
				if(Usuario_idUsuario!=null) ord.setUsuario_idUsuario(Usuario_idUsuario);
				repository.save(ord);
				tmpOrd = ord;
			}//if
		return tmpOrd;
	}//update orden
	
}//class OrdenService

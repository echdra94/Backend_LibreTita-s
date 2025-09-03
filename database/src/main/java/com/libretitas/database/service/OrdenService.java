package com.libretitas.database.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libretitas.database.model.Orden;


@Service
public class OrdenService {
	private final ArrayList<Orden> lista = new ArrayList<Orden>();
	@Autowired
	public OrdenService() {
        lista.add(new Orden(LocalDate.parse("2025-08-28"), 250.00, 1));
        lista.add(new Orden(LocalDate.parse("2025-09-06"), 750.00, 2));
        lista.add(new Orden(LocalDate.parse("2025-08-20"), 500.00, 3));
        lista.add(new Orden(LocalDate.parse("2025-07-04"), 600.00, 3));
        lista.add(new Orden(LocalDate.parse("2025-08-25"), 600.00, 3));
	}//constructor
	
	public List<Orden> getOrdenes(){
		return lista;
	}//getOrdenes
	
	public Orden getOrden(Long id) {
		Orden tmpOrd = null;
		for (Orden ord : lista) {
			if(ord.getId()==id) {
				tmpOrd=ord;
				break;
			}//if
		}// foreach
		return tmpOrd;
	}// getOrden
	
	
	public Orden deleteOrden(Long id) {
		Orden tmpOrd = null;
		for (Orden ord : lista) {
			if(ord.getId()==id) {
				tmpOrd=ord;
				lista.remove(ord);
				break;
			}//if
		}// foreach
		return tmpOrd;
	}// deleteOrden
	
	public Orden addOrden(Orden orden) {
		lista.add(orden);
		return orden;
	}// addOrden
	
	
	public Orden updateOrden(Long id, LocalDate fecha, Double totalOrden, Integer idUsuario) {
		Orden tmpOrd=null;
		for (Orden ord : lista) {
			if(ord.getId()==id) {
				if(fecha!=null) ord.setFecha(fecha);
				if(totalOrden!=null) ord.setTotalOrden(totalOrden);
				if(idUsuario!=null) ord.setIdUsuario(idUsuario);
				tmpOrd = ord;
				break;
			}//if
		}//foreach
		return tmpOrd;
	}
	
	
	
	
}//class OrdenService

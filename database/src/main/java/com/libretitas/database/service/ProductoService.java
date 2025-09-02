package com.libretitas.database.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libretitas.database.model.Producto;

@Service
public class ProductoService {
	private final ArrayList<Producto> lista = new ArrayList<Producto>();
	@Autowired
	
	// String nombreProducto, String descripcion, Double precio, String imagen, int existencias
	public ProductoService() {
		lista.add(new Producto("Modelo: Taquilla", "Libreta tamaño media carta, cubierta tapa dura, encuadernado tipo wire-o, papel rayado, 90 hojas", 250.00, "https://res.cloudinary.com/libretitaspi/image/upload/v1755039753/mockup_de_libreta_media_carta_kathkath_iffsyo.png", 5));
		lista.add(new Producto("Modelo: Piel", "Libreta tamaño media carta, cubierta tapa dura de vinipiel suave al tacto, encuadernado tipo costura francesa, papel rayado, 90 hojas", 500.00, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038924/IMG_20210731_015909_rocibk.jpg", 6));
		lista.add(new Producto("Modelo: Burrito de Mar", "Libreta tamaño media carta, cubierta tapa dura de vinipiel suave al tacto, encuadernado tipo costura francesa, papel rayado, 90 hojas", 500.00, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038922/IMG_20220731_224841_t9kffe.jpg", 7));
		lista.add(new Producto("Modelo: IPN anatómico","Libreta tamaño media carta, cubierta tapa dura, encuadernado tipo wire-o, papel rayado, 90 hojas",250.00, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038923/IMG_20220809_205901_vi3581.jpg" ,3));
		lista.add(new Producto("Modelo: Tradicional", "Libreta media carta, cubierta dura , con 90 hojas, encuadernado tipo wire-o, lista para ti.", 250.00, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038923/agenda_guinda_simulacion_2_riicmb.png", 3));
		lista.add(new Producto("Modelo: Huelum", "Libreta tamaño media carta, cubierta dura, encuadernado tipo wire-o, papel rayado, 90 hojas", 250.00, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038924/4_f5vumn.png", 5));
		lista.add(new Producto("Modelo: Lazarillo", "Libreta pocket,pasta blanda,con 60 hojas,comoda para llevar a todas partes.", 200.00, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038923/IMG_20220731_224530_l6j4lu.jpg", 5));
		lista.add(new Producto("Modelo: Esimio", "Libreta pocket con 60 hojas, ofrece un espacio para tomar notas, escribir tus aventuras o escribir ideas. Su tamaño hace que sean portables y ocupen poco espacio en tu bolsa o mochila", 200.00, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038923/IMG_20220731_224040_pbkirv.jpg",5));
		lista.add(new Producto("Modelo: México", "libreta profesional con 90 hojas, con encuadernación anillada wire-o, cuadro grande. Ideal para tus apuntes escolares o grandes ideas que requieran un amplio espacio para ser plasmadas.", 250.00, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038923/Modelo_M%C3%A9xico_1_pxjtwr.png",5));
		lista.add(new Producto("Carpeta: Insignia", "carpeta profesional, con encuadernación en tapa dura y capacidad para 250 hojas, las cuales se venden por separado pudiendo elegir el modelo de tu elección.", 300.00, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038922/insignia_c1_g0tlm7.jpg",5));
	}// CONSTRUCTOR
	public List<Producto> getProducts() {
		return lista;
	}//getProducts
	
	public Producto getProduct(Long id) {
		Producto tmpProd = null;
		for (Producto prod : lista) {
			if(prod.getId()==id) {
				tmpProd=prod;
				break;
			}//if
		}// foreach
		return tmpProd;
	}// getProduct
	
	public Producto deleteProduct(Long id) {
		Producto tmpProd = null;
		for (Producto prod : lista) {
			if(prod.getId()==id) {
				tmpProd=prod;
				lista.remove(prod);
				break;
			}//if
		}// foreach
		return tmpProd;
	}// deleteProduct
	
	public Producto addProduct(Producto producto) {
		lista.add(producto);
		return producto;
	}// addProduct
	
	public Producto updateProduct(Long id, String nombreProducto, String descripcion, Double precio, String imagen,Integer existencias) {
		Producto tmpProd = null;
		for (Producto prod : lista) {
			if(prod.getId()==id) {
				if(nombreProducto!=null) prod.setNombreProducto(nombreProducto);
				if(descripcion!=null) prod.setDescripcion(descripcion);
				if(precio!=null) prod.setPrecio(precio);
				if(imagen!=null) prod.setImagen(imagen);
				if(existencias!=null) prod.setExistencias(existencias);
				tmpProd = prod;
				break;
				
			}// if
		}// for each
		return tmpProd;
	}//updateProduct
	
	
}//class ProductoService

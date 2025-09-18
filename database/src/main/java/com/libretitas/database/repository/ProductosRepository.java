package com.libretitas.database.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.libretitas.database.model.Producto;

@Repository
public interface ProductosRepository extends JpaRepository<Producto, Long>{
	Optional<Producto> findByNombreProducto(String nombreProducto);
}// Interface ProductosRepository

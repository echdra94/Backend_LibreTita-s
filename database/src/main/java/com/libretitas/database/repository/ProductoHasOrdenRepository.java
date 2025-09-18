package com.libretitas.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libretitas.database.model.ProductoHasOrden;

@Repository
public interface ProductoHasOrdenRepository extends JpaRepository<ProductoHasOrden, Long>{

}

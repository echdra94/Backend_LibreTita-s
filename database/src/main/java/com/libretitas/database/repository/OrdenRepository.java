package com.libretitas.database.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.libretitas.database.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long>{
	Optional<Orden> findById(Long idOrden);
}

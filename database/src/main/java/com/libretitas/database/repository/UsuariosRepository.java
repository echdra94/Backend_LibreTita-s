package com.libretitas.database.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.libretitas.database.model.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByCorreo(String correo);

}//Interface UsuarosRepository

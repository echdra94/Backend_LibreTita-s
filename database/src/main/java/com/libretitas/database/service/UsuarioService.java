package com.libretitas.database.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libretitas.database.dto.CambiarContraseña;
import com.libretitas.database.model.Usuario;
import com.libretitas.database.repository.UsuariosRepository;

@Service
public class UsuarioService {
	private final UsuariosRepository repository;
	@Autowired
	public UsuarioService(UsuariosRepository repository) {
	this.repository = repository;
	}//Constructor 
	
	public List<Usuario> getUsuarios() {
		return repository.findAll();
	}//getUsers
	
	public Usuario getUsuario(Long idUsuario) {
		return repository.findById(idUsuario).orElseThrow(
				()-> new IllegalArgumentException("El usuario con el id ["+idUsuario+"] no existe")
				);
	}//getUsuario
	
	public Usuario deleteUser(Long idUsuario) {
		Usuario tmpUsr=null;
		if (repository.existsById(idUsuario)) {
			tmpUsr=repository.findById(idUsuario).get();
			repository.deleteById(idUsuario);
		}//if
		return tmpUsr;
	}//deleteUser
	
	
	public Usuario addUsuario(Usuario usuario) {
		Optional<Usuario> usr= 
				repository.findByCorreo(usuario.getCorreo());
		if(usr.isEmpty()) {
			usuario.setContraseña(usuario.getContraseña());
			repository.save(usuario);
		} else {
			usuario = null;
		}//else
		return usuario;
	}//addUsuario

	public Usuario updateUsuario(Long idUsuario, CambiarContraseña cambiarContraseña) {
	Usuario usuario = null;
	if(repository.existsById(idUsuario)) {
		usuario=repository.findById(idUsuario).get();
		if (usuario.getContraseña().equals(cambiarContraseña.getContraseña())) {
			usuario.setContraseña(cambiarContraseña.getNcontraseña() );
			return repository.save(usuario);
		} else {
			usuario=null;
		}//equals
	}//if exists 
	return usuario;
	}//updateUsuario

	
}//class UsuarioService

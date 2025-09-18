package com.libretitas.database.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.libretitas.database.dto.CambiarContraseña;
import com.libretitas.database.model.Usuario;
import com.libretitas.database.repository.UsuariosRepository;

@Service
public class UsuarioService {
	private final UsuariosRepository repository;
	@Autowired
	private PasswordEncoder encoder;
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
			usuario.setContraseña(encoder.encode(usuario.getContraseña()));
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
		//if(usuario.getContraseña().equals(cambiarContraseña.getContraseña())) {
		if(encoder.matches(cambiarContraseña.getContraseña(), usuario.getContraseña()))	{
		usuario.setContraseña(encoder.encode(cambiarContraseña.getNcontraseña()) );
			return repository.save(usuario);
		} else {
			usuario=null;
		}//equals
	}//if exists 
	return usuario;
	}//updateUsuario

	public boolean validateUser(Usuario usuario) {
		Optional<Usuario> user= repository.findByCorreo(usuario.getCorreo());
		if (user.isPresent()) {
			Usuario tmpUser = user.get();
			if(encoder.matches(usuario.getContraseña(), tmpUser.getContraseña())) {
				return true;
			}//if Matches
		}//isPresent
		return false;
	}//validateUser

	
}//class UsuarioService

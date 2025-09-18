package com.libretitas.database.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libretitas.database.dto.CambiarContraseña;
import com.libretitas.database.model.Usuario;
import com.libretitas.database.service.UsuarioService;

@RestController
@RequestMapping(path="/api/usuarios/") //http//:localhost8080/api/usuarios
public class UsuarioController {
	private final UsuarioService service;
	@Autowired
	public UsuarioController(UsuarioService service) {
		this.service=service;
	}//constructor

	//GET todos
	@GetMapping
	public List<Usuario> getUsuarios() {
		return service.getUsuarios();
	}
	//GET un usuario
	@GetMapping(path="{UserId}")//http//:localhost8080/api/usuarios/1
	public Usuario getUsuario(@PathVariable("UserId") Long idUsuario) {
		return service.getUsuario(idUsuario);
		}//getUsuario
		
	//DELETE
	@DeleteMapping (path="{UserId}")//http//:localhost8080/api/usuarios/1
	public Usuario deleteUsuario(@PathVariable("UserId") Long idUsuario) {
	return service.deleteUser(idUsuario);
		}//deleteUser
		
	//POST
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
	return service.addUsuario(usuario);
		}//addUsuario
	
	
	//PUT
	@PutMapping (path="{UserId}")//http//:localhost8080/api/usuarios/1
	public Usuario updateUsuario(@PathVariable("UserId") Long idUsuario, 
		@RequestBody CambiarContraseña cambiarContraseña) {
		return service.updateUsuario(idUsuario, cambiarContraseña);
			}//updateUser
	
}//class UsuarioController

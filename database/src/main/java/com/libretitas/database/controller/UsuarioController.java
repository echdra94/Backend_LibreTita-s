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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
		return service.getUsers();
	}
	//GET un usuario
		@GetMapping(path="{UserId}")//http//:localhost8080/api/usuarios/1
		public Usuario getUsuario(@PathVariable("UserId") Long id) {
			return service.getUsuario(id);
		}//getUsuario
		
	//DELETE
		@DeleteMapping (path="{UserId}")//http//:localhost8080/api/usuarios/1
		public Usuario deleteUsuario(@PathVariable("UserId") Long id) {
			return service.deleteUser(id);
		}//deleteUser
		
	//POST
		@PostMapping
		public Usuario addUsuario(@RequestBody Usuario usuario) {
			return service.addUser(usuario);
		}
	//PUT
		@PutMapping (path="{UserId}")//http//:localhost8080/api/usuarios/1
		public Usuario updateUsuario(@PathVariable("UserId") Long id, 
			@RequestParam (name = "nombre", required=false) String nombre,
			@RequestParam (name= "apellido", required=false) String apellido,
			@RequestParam (name= "correo", required=false) String correo,
			@RequestParam (name= "contraseña", required=false) String contraseña,
			@RequestParam (name= "telefono", required=false) String telefono,
			@RequestParam (name= "promociones", required=false) Boolean promociones){
				return service.updateUser(id, nombre, apellido, correo, contraseña, telefono, promociones);
			}//updateUser
	
}//class UsuarioController

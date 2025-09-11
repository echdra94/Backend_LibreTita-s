package com.libretitas.database.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libretitas.database.config.JwtFilter;
import com.libretitas.database.dto.Token;
import com.libretitas.database.model.Usuario;
import com.libretitas.database.service.UsuarioService;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/") //http://localhost:8080/api/login/
public class LoginController {

	private final UsuarioService service;
	@Autowired
	public LoginController(UsuarioService service) {
		this.service=service;
	}//constructor
	
	@PostMapping
	public Token loginUser(@RequestBody Usuario usuario) 
							throws ServletException {
		if(service.validateUser(usuario)) {
			return new Token(generateToken( usuario.getCorreo()));
		}//if validateUser
	throw new ServletException("Nombre de usuario o contraseña incorectos["+usuario.getCorreo()+"]");
	}//login user
	
	private String generateToken (String correo) {
		Calendar calendar = Calendar.getInstance();
		//calendar.add(0Calendar.MINUTE, 30);
		calendar.add(Calendar.HOUR, 24);
		
		return Jwts.builder().setSubject(correo)
				.claim("role", "user")
				.setIssuedAt(new Date())
				.setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
				.compact();
	}//generateToken
		
}//class

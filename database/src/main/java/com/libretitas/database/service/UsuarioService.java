package com.libretitas.database.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libretitas.database.model.Usuario;

@Service
public class UsuarioService {
	private final ArrayList<Usuario> lista =new ArrayList<Usuario>();
	@Autowired
	
	//String nombre, String apellido, String correo, String contraseña, String telefono, Boolean promociones
	public UsuarioService() {
	lista.add(new Usuario("Alejandra", "Echavarria", "alejandraegib@gmail.com", "Alejandra123!", "8341010016", true));
    lista.add(new Usuario("Natalia", "Esquivel", "nataliaeo12@gmail.com", "NataliaEO12@", "5589631585", true));
    lista.add(new Usuario("Mariell", "Zamora", "zamoramariell29@gmail.com", "MarZamora29!", "5581808909", true));
    lista.add(new Usuario("Marisol", "Díaz", "jimenezdiazm158@gmail.com", "Mary2322.", "5566173426", false));
    lista.add(new Usuario("Anya" , "Mares" , "anyamares@gmail.com" , "anyvany" , "3317796365", false));
    lista.add(new Usuario("Ana", "Guevara", "anaguevaraaguilar37@gmail.com", "Ana12!", "5551234567", false));
    lista.add(new Usuario("Stefani", "Cosío", "stefanicos@gmail.com", "Stefani123$", "5580334144", false));
    lista.add(new Usuario("Griselda", "Romero", "griselda.romero.mart@gmail.com", "Gr1s3lD&", "5540846124", true));
	}//Constructor parámetros
	public List<Usuario> getUsers() {
		return lista;
	}//getUsers
	public Usuario getUsuario(Long id) {
		Usuario tmpUsr=null;
		for (Usuario usr: lista) {
			if (usr.getId()==id) {
				tmpUsr=usr;
				break;
			}//if
		}//foreach
		return tmpUsr;
	}//getUsuario
	
	public Usuario deleteUser(Long id) {
		Usuario tmpUsr=null;
		for (Usuario usr: lista) {
			if (usr.getId()==id) {
				tmpUsr=usr;
				break;
			}//if
		}//foreach
		return tmpUsr;
	}//deleteUser
	
	public Usuario addUser(Usuario usuario) {
		lista.add(usuario);
		return usuario;
	}//addUser
	
	public Usuario updateUser(Long id, String nombre, String apellido, String correo, String contraseña,
			String telefono, Boolean promociones) {
		Usuario tmpUsr=null;
		for (Usuario usr : lista) {
			if(usr.getId()==id) {
				if(nombre!=null)usr.setNombre(nombre);
				if(apellido!=null)usr.setApellido(apellido);
				if(correo!=null)usr.setCorreo(correo);
				if(contraseña!=null)usr.setContraseña(contraseña);
				if(telefono!=null)usr.setTelefono(telefono);
				if(promociones!=null)usr.setPromociones(promociones);
				tmpUsr = usr;
				break;
			}//if
		}//forEach
			return tmpUsr;
	}//updateUser
	
}//class UsuarioService

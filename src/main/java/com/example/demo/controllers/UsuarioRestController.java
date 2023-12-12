package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.models.entity.Usuario;
import com.example.demo.models.services.IUsuarioService;


@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	@Autowired
	private IUsuarioService usuariosService;
	
	//listar todos los usuarios
	@GetMapping("/usuario")
	public List<Usuario> indext(){
		return usuariosService.findAll();
	}
	//Buscar un usuario por id
	@GetMapping("/usuario/{id}")
	public Usuario show(@PathVariable Long id) {
		return usuariosService.findById(id);
	}
	
	//guarda un usuario
	@PostMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuarios) {
		return usuariosService.save(usuarios);
	}
	
	//edita un usuario
	@PutMapping("/usuario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuarios, @PathVariable Long id) {
		Usuario usuarioActual = usuariosService.findById(id);
		usuarioActual.setNombre(usuarios.getNombre());
		usuarioActual.setClave(usuarios.getClave());
		usuarioActual.setEmail(usuarios.getEmail());
		usuarioActual.setEstado(usuarios.getEstado());
		return usuariosService.save(usuarioActual);
	}
	
	//Elimina un usuario
	@DeleteMapping ("/usuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		usuariosService.delete(id);
	}
}

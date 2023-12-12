package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Usuario;

public interface IUsuarioService {
	public List<Usuario> findAll();
	public Usuario save(Usuario usuarios);
	public Usuario findById(Long id);
	public void delete (Long id);
}

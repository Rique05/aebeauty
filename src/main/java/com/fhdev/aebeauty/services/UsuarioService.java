package com.fhdev.aebeauty.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhdev.aebeauty.domain.Usuario;
import com.fhdev.aebeauty.repositories.UsuarioRepository;
import com.fhdev.aebeauty.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public List<Usuario> findAll(){
		
		List<Usuario> usuarios = repo.findAll();
		
		//Condição que verifica se a lista de usuários está vazia. Se estiver, lança a exceção
		if(usuarios.isEmpty()) {
			
			throw new ObjectNotFoundException(
					"Objetos não encontrados!, Tipo: " + Usuario.class.getName());
		}
		
		return usuarios;
	}
	
	public Usuario find(Integer id) {
		Optional<Usuario> usuario = repo.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

}

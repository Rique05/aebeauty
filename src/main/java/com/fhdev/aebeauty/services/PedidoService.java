package com.fhdev.aebeauty.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhdev.aebeauty.domain.Pedido;
import com.fhdev.aebeauty.repositories.PedidoRepository;
import com.fhdev.aebeauty.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public List<Pedido> findAll(){
		
		List<Pedido> pedidos = repo.findAll();
	
		//Condição que verifica se a lista de pedidos está vazia. Se estiver, lança a exceção
				if(pedidos.isEmpty()) {
					
					throw new ObjectNotFoundException(
							"Objetos não encontrados!, Tipo: " + Pedido.class.getName());
				}	
				
		return pedidos;	
	}
	
	public Pedido find(Integer id) {
		
		Optional<Pedido> pedido = repo.findById(id);
		return pedido.orElseThrow(() -> new ObjectNotFoundException( //Exceção personalizada para busca
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		
	}

}

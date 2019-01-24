package com.fhdev.aebeauty.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fhdev.aebeauty.domain.Pedido;
import com.fhdev.aebeauty.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	private ResponseEntity<?> findAll(){
		
		List<Pedido> pedidos = service.findAll();
		return ResponseEntity.ok().body(pedidos);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Pedido pedido = service.find(id);
		return ResponseEntity.ok().body(pedido);
		
	}

}

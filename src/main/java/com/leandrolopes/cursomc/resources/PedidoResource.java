package com.leandrolopes.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leandrolopes.cursomc.domain.Pedido;
import com.leandrolopes.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pedido> find(@PathVariable Long id) {
		Pedido obj = pedidoService.find(id);		
		return ResponseEntity.ok().body(obj);
	}

}

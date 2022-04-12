package com.leandrolopes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandrolopes.cursomc.domain.Pedido;
import com.leandrolopes.cursomc.repositories.PedidoRepository;
import com.leandrolopes.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido buscar(Long id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);				
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " 
							+ "Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
}

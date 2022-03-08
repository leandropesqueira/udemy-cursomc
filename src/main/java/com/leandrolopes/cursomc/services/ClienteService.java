package com.leandrolopes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandrolopes.cursomc.domain.Cliente;
import com.leandrolopes.cursomc.repositories.ClienteRepository;
import com.leandrolopes.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Long id) {
		Optional<Cliente> obj = clienteRepository.findById(id);				
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " 
							+ "Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
}

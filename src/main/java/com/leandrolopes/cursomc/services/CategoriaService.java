package com.leandrolopes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandrolopes.cursomc.domain.Categoria;
import com.leandrolopes.cursomc.repositories.CategoriaRepository;
import com.leandrolopes.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Long id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);				
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " 
							+ "Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
}

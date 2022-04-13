package com.leandrolopes.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.leandrolopes.cursomc.domain.Categoria;
import com.leandrolopes.cursomc.repositories.CategoriaRepository;
import com.leandrolopes.cursomc.services.exceptions.DataIntegrityException;
import com.leandrolopes.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);				
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " 
							+ "Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		findById(obj.getId());
		return categoriaRepository.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Categoria que possui Produtos.");		
		}
	}

	public List<Categoria> findAll() {		
		return categoriaRepository.findAll();
	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return categoriaRepository.findAll(pageRequest);
	}
}

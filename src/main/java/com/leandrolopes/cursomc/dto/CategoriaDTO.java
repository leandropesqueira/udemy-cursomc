package com.leandrolopes.cursomc.dto;

import java.io.Serializable;

import com.leandrolopes.cursomc.domain.Categoria;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTO implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	private Long id;		
	private String nome;
	
	public CategoriaDTO (Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

}

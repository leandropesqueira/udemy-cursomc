package com.leandrolopes.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Categoria implements Serializable{	
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;		
	private String nome;
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "categorias")
	private List<Produto> produtos = new ArrayList<>();

	public Categoria(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}	

}

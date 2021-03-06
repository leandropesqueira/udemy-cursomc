package com.leandrolopes.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leandrolopes.cursomc.domain.enums.EstadoPagamento;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include
	private Long id;
	private Integer estado;
	
	@JsonIgnore	
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId
	private Pedido pedido;

	public Pagamento(Long id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = (estado==null) ? null : estado.getCod();
		this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}	

}

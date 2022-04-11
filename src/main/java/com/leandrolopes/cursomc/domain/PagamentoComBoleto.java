package com.leandrolopes.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.leandrolopes.cursomc.domain.enums.EstadoPagamento;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PagamentoComBoleto extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto(Long id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);		
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}
	
}

package com.cmtehenz.conta.model;

public enum StatusPagamento {

	
	PENDENTE("Pendente"), 
	PAGO("Pago");
	
	private String descricao;
	
	StatusPagamento(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}

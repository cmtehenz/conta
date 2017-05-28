package com.cmtehenz.conta.model;

public enum StatusLancamentos {

	PENDENTE("Pendente"), 
	PAGO("Pago");
	
	private String descricao;
	
	StatusLancamentos(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}

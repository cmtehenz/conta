package com.cmtehenz.conta.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cmtehenz.conta.model.Lancamento;
import com.cmtehenz.conta.repository.Lancamentos;

@Service
public class LancamentoService {
	
	@Autowired
	private Lancamentos lancamentos;
	
	public void salvar(Lancamento lancamento){
		try{
			lancamentos.save(lancamento);
		}catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
	}

}

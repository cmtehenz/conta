package com.cmtehenz.conta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmtehenz.conta.model.Lancamento;
import com.cmtehenz.conta.repository.Lancamentos;

@Controller
@RequestMapping("/lancamentos")
public class LancamentosController {
	
	@Autowired
	private Lancamentos lancamentos;
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mode = new ModelAndView("CadastroLancamento");
				
		return mode;
	}
	
	@RequestMapping
	public ModelAndView pesquisar(){
		ModelAndView mode = new ModelAndView("Lancamentos");
		
		return mode;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Lancamento lancamento){
		lancamentos.save(lancamento);
		return "CadastroLancamento";
	}

}

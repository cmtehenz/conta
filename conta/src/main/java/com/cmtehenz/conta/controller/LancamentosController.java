package com.cmtehenz.conta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lancamentos")
public class LancamentosController {
	
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

}

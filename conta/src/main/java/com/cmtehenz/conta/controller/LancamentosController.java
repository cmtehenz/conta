package com.cmtehenz.conta.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cmtehenz.conta.Service.LancamentoService;
import com.cmtehenz.conta.model.Categoria;
import com.cmtehenz.conta.model.Lancamento;
import com.cmtehenz.conta.model.StatusLancamentos;
import com.cmtehenz.conta.repository.Categorias;
import com.cmtehenz.conta.repository.Lancamentos;

@Controller
@RequestMapping("/lancamentos")
public class LancamentosController {
	
	@Autowired
	private Lancamentos lancamentos;
	
	@Autowired
	private Categorias categorias;
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mode = new ModelAndView("CadastroLancamento");		
		mode.addObject(new Lancamento());
		return mode;
	}
	
	@RequestMapping
	public ModelAndView pesquisar(){
		List<Lancamento> todosLancamentos = lancamentos.findAll();
		ModelAndView mode = new ModelAndView("Lancamentos");
		mode.addObject("lancamentos", todosLancamentos);
		
		return mode;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Lancamento lancamento, Errors erro, RedirectAttributes atributes){
		if(erro.hasErrors()){
			
			return "CadastroLancamento";			
		}		
		try{
			lancamentoService.salvar(lancamento);		
			atributes.addFlashAttribute("mensagem", "Lançamento salvo com sucesso!");		
			return "redirect:/lancamentos/novo";
		}catch (IllegalArgumentException e) {
			erro.rejectValue("dataVencimento", null, e.getMessage());
			return "CadastroLancamento";
		}
	}
	
	
	
	@ModelAttribute("todosStatusLancamento")
	public List<StatusLancamentos> todosStatusLancamentos(){
		return Arrays.asList(StatusLancamentos.values());
	}
	
	@ModelAttribute("todasCategoria")
	public List<Categoria> todasCategorias(){
		List<Categoria> todasCategorias = categorias.findAll();
		return todasCategorias;
	} 
	
	
	
	

}

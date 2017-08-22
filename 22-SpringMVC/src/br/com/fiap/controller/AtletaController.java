package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.model.Atleta;

@Controller
@RequestMapping("/atleta")
public class AtletaController {
	
	@GetMapping("/cadastrar")
	public String abrirForm(){
		return "atleta/cadastro";
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrarAtleta(Atleta atleta){
		System.out.println(atleta.getNome()+ ", " + atleta.getAltura()+ " de altura,e "+atleta.getPeso()+" Kg de peso.");
		ModelAndView retorno = new ModelAndView("atleta/lista");
		retorno.addObject("atleta",atleta);
		return retorno;
	}
	
	
	
}

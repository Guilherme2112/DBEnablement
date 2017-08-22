package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.model.Time;

@Controller
@RequestMapping("/time")
public class TimeController {
	@GetMapping("cadastro")
	public String showForm(){
		return "time/cadastro";
	}
	@PostMapping("cadastro")
	public ModelAndView cadastrar(Time time){
		ModelAndView mdl = new ModelAndView("time/lista");
		mdl.addObject("time",time);
		return mdl;
	}
}

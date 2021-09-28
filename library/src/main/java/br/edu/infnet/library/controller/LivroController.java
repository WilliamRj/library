package br.edu.infnet.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.library.service.LivroService;

@Controller
@RequestMapping(value="/livro")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@RequestMapping(value="/cadastro", method = RequestMethod.GET)
	public String cadastro() {
		return "/livro";
	}

}

package br.edu.infnet.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.library.model.Livro;
import br.edu.infnet.library.service.LivroService;

@Controller
@RequestMapping(value="/livro")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@RequestMapping(value="/cadastro", method = RequestMethod.GET)
	public String listaLivros(Model model) {
		List<Livro> livros =  livroService.listAll();
		model.addAttribute("livros", livros);
		return "/livro/livro";
	}
	
	@RequestMapping(value="/cadastro/formL", method = RequestMethod.GET)
	public String cadastroFormL() {
		return "/livro/formLivro";
	}
	
	@RequestMapping(value="/cadastro/formA", method = RequestMethod.GET)
	public String cadastroFormA() {
		return "/livro/formAutor";
	}
	
	@RequestMapping(value="/cadastro/formC", method = RequestMethod.GET)
	public String cadastroFormC() {
		return "/livro/formCategoria";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Livro livro) {
		
		//executar a ação de salvar
		livroService.salvar(livro);
		
		return "redirect:/livro/cadastro";
	}	
	
	@RequestMapping(value = "/cadastro/edit/{codigo_livro}", method = RequestMethod.GET)
	public String formEdit(@PathVariable("codigo_livro") Integer codigo_livro, Model model) {
		Optional<Livro> byId = livroService.getById(codigo_livro);
		if(byId.isPresent()) {
			model.addAttribute("livro", byId.get());
		}
		return "/livro/formLivroEdit";
	}
	

	@RequestMapping(value = "cadastro/delete/{codigo_livro}", method = RequestMethod.GET)
	public String delete(@PathVariable("codigo_livro") Integer codigo_livro) {
		livroService.delete(codigo_livro);
		return "redirect:/livro/cadastro";
	}

}

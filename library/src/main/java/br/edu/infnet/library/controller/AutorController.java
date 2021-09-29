package br.edu.infnet.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.library.model.Autor;
import br.edu.infnet.library.service.AutorService;

@Controller
@RequestMapping(value="/autor")
public class AutorController {
	
	@Autowired
	private AutorService autorService;
	
	@RequestMapping(value="/cadastro", method = RequestMethod.GET)
	public String listaAutores(Model model) {
		List<Autor> autores =  autorService.listAll();
		model.addAttribute("autores", autores);
		return "/autor/autor";
	}
	
	@RequestMapping(value="/cadastro/formA", method = RequestMethod.GET)
	public String cadastroForm() {
		return "/autor/formAutor";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Autor autor) {
		
		//executar a ação de salvar
		autorService.salvar(autor);
		
		return "redirect:/autor/cadastro";
	}	
	
	@RequestMapping(value = "/cadastro/edit/{codigo_autor}", method = RequestMethod.GET)
	public String formEdit(@PathVariable("codigo_autor") Integer codigo_autor, Model model) {
		Optional<Autor> byId = autorService.getById(codigo_autor);
		if(byId.isPresent()) {
			model.addAttribute("autor", byId.get());
		}
		return "/autor/formAutorEdit";
	}
	

	@RequestMapping(value = "cadastro/delete/{codigo_autor}", method = RequestMethod.GET)
	public String delete(@PathVariable("codigo_autor") Integer codigo_autor) {
		autorService.delete(codigo_autor);
		return "redirect:/autor/cadastro";
	}

}

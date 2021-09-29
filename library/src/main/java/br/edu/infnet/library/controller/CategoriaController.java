package br.edu.infnet.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.library.model.Categoria;
import br.edu.infnet.library.service.CategoriaService;

@Controller
@RequestMapping(value="/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="/cadastro", method = RequestMethod.GET)
	public String listaCategorias(Model model) {
		List<Categoria> categorias =  categoriaService.listAll();
		model.addAttribute("categorias", categorias);
		return "/categoria/categoria";
	}
	
	@RequestMapping(value="/cadastro/formC", method = RequestMethod.GET)
	public String cadastroForm() {
		return "/categoria/formCategoria";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Categoria categoria) {
		
		//executar a ação de salvar
		categoriaService.salvar(categoria);
		
		return "redirect:/categoria/cadastro";
	}	
	
	@RequestMapping(value = "/cadastro/edit/{codigo_categoria}", method = RequestMethod.GET)
	public String formEdit(@PathVariable("codigo_categoria") Integer codigo_categoria, Model model) {
		Optional<Categoria> byId = categoriaService.getById(codigo_categoria);
		if(byId.isPresent()) {
			model.addAttribute("categoria", byId.get());
		}
		return "/categoria/formCategoriaEdit";
	}
	

	@RequestMapping(value = "cadastro/delete/{codigo_categoria}", method = RequestMethod.GET)
	public String delete(@PathVariable("codigo_categoria") Integer codigo_categoria) {
		categoriaService.delete(codigo_categoria);
		return "redirect:/categoria/cadastro";
	}

}

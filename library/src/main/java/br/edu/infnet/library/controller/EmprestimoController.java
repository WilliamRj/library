package br.edu.infnet.library.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.library.model.Autor;
import br.edu.infnet.library.model.Categoria;
import br.edu.infnet.library.model.Cliente;
import br.edu.infnet.library.model.Emprestimo;
import br.edu.infnet.library.model.Livro;
import br.edu.infnet.library.service.ClienteService;
import br.edu.infnet.library.service.EmprestimoService;
import br.edu.infnet.library.service.LivroService;

@Controller
@RequestMapping(value="/emprestimo")
public class EmprestimoController {
	
	@Autowired
	private EmprestimoService emprestimoService;
	
	@Autowired
	private LivroService livroService;

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/cadastro", method = RequestMethod.GET)
	public String listaEmprestimos(Model model) {
		List<Emprestimo> emprestimos =  emprestimoService.listAll();
		model.addAttribute("emprestimos", emprestimos);
		
//		List<Cliente> clientes = new ArrayList<Cliente>();
		HashMap<Long,String> clientes = new HashMap<Long,String>();
		HashMap<Long,String> livros = new HashMap<Long,String>();
		
		for(Emprestimo e : emprestimos){
            Optional<Cliente> clienteById = clienteService.getById(e.getCodigo_cliente());
            if(clienteById.isPresent()) {
            	clientes.put((e.getCodigo_emprestimo()).longValue(), clienteById.get().getNome());
    		}
            
            Optional<Livro> livroById = livroService.getById(e.getCodigo_livro());
            if(livroById.isPresent()) {
            	livros.put((e.getCodigo_emprestimo()).longValue(), livroById.get().getTituloLivro());
            }
        }
		model.addAttribute("clientes", clientes);
		model.addAttribute("livros", livros);
		
		return "/emprestimo/emprestimo";
	}
	
	@RequestMapping(value="/cadastro/form", method = RequestMethod.GET)
	public String cadastroForm(Model model) {
		List<Livro> livros =  livroService.buscarNaoEmprestados();
		List<Cliente> clientes =  clienteService.listAll();
		model.addAttribute("livros", livros);
		model.addAttribute("clientes", clientes);
//		List<Categoria> categorias =  categoriaService.listAll();
//		model.addAttribute("categorias", categorias);
		return "/emprestimo/formEmprestimo";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Emprestimo emprestimo) {		
		//executar a ação de salvar
		emprestimoService.salvar(emprestimo);
		
		return "redirect:/emprestimo/cadastro";
	}
	
	@RequestMapping(value = "/salvarD", method = RequestMethod.POST)
	public String salvarDevolucao(Emprestimo emprestimo) {		
		//executar a ação de salvar
		emprestimoService.salvarDevolucao(emprestimo);
		
		return "redirect:/emprestimo/cadastro";
	}
	
	@RequestMapping(value = "/cadastro/edit/{codigo_emprestimo}", method = RequestMethod.GET)
	public String formEdit(@PathVariable("codigo_emprestimo") Integer codigo_emprestimo, Model model) {
		Optional<Emprestimo> byId = emprestimoService.getById(codigo_emprestimo);
		if(byId.isPresent()) {
			model.addAttribute("emprestimo", byId.get());
		}
		return "/emprestimo/formEmprestimoEdit";
	}
	
	@RequestMapping(value = "/cadastro/devolucao/{codigo_emprestimo}", method = RequestMethod.GET)
	public String formDevolucao(@PathVariable("codigo_emprestimo") Integer codigo_emprestimo, Model model) {
		Optional<Emprestimo> byId = emprestimoService.getById(codigo_emprestimo);
		if(byId.isPresent()) {
			model.addAttribute("emprestimo", byId.get());
		}
		return "/emprestimo/formEmprestimoDevolucao";
	}
	

	@RequestMapping(value = "cadastro/delete/{codigo_emprestimo}", method = RequestMethod.GET)
	public String delete(@PathVariable("codigo_emprestimo") Integer codigo_emprestimo) {
		emprestimoService.delete(codigo_emprestimo);
		return "redirect:/emprestimo/cadastro";
	}

}

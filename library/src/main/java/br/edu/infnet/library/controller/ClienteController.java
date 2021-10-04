package br.edu.infnet.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.infnet.library.model.Cliente;
import br.edu.infnet.library.service.ClienteService;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/cadastro", method = RequestMethod.GET)
	public String listaClientes(Model model) {
		List<Cliente> clientes =  clienteService.listAll();
		model.addAttribute("clientes", clientes);
		return "/cliente/cliente";
	}
	
	@RequestMapping(value="/cadastro/form", method = RequestMethod.GET)
	public String cadastroForm() {
		return "/cliente/formCliente";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Cliente cliente) {
		
		//executar a ação de salvar
		clienteService.salvar(cliente);
		
		return "redirect:/cliente/cadastro";
	}	
	
	@RequestMapping(value = "/cadastro/edit/{codigo_cliente}", method = RequestMethod.GET)
	public String formEdit(@PathVariable("codigo_cliente") Integer codigo_cliente, Model model) {
		Optional<Cliente> byId = clienteService.getById(codigo_cliente);
		if(byId.isPresent()) {
			model.addAttribute("cliente", byId.get());
		}
		return "/cliente/formClienteEdit";
	}

	@RequestMapping(value = "cadastro/delete/{codigo_cliente}", method = RequestMethod.GET)
	public String delete(@PathVariable("codigo_cliente") Integer codigo_cliente) {
		clienteService.delete(codigo_cliente);
		return "redirect:/cliente/cadastro";
	}
	
}

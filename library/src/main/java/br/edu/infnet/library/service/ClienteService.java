package br.edu.infnet.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.library.model.Cliente;
import br.edu.infnet.library.model.Livro;
import br.edu.infnet.library.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		//Regras de Negócio
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listAll(){
		return clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
//		return clienteRepository.findAll();
	}
	
	public List<Cliente> listAllSorted(){
		return clienteRepository.findAllSorted();
	}
	
	public Optional<Cliente> getById(Integer codigo_cliente) {
		return clienteRepository.findById(codigo_cliente);
	}
	
	public void delete(Integer codigo_cliente) {
		clienteRepository.deleteById(codigo_cliente);
	}
	
}

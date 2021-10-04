package br.edu.infnet.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.library.model.Autor;
import br.edu.infnet.library.repository.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;
	
	public Autor salvar(Autor autor) {
		//Regras de Negócio
		return autorRepository.save(autor);
	}
	
	public List<Autor> listAll(){
		return autorRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public Optional<Autor> getById(Integer codigo_autor) {
		return autorRepository.findById(codigo_autor);
	}
	
	public void delete(Integer codigo_autor) {
		autorRepository.deleteById(codigo_autor);
	}

}

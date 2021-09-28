package br.edu.infnet.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.library.model.Livro;
import br.edu.infnet.library.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public Livro salvar(Livro livro) {
		//Regras de Negócio
		return livroRepository.save(livro);
	}
	
	public List<Livro> listAll(){
		return livroRepository.findAll();
	}
	
	public Optional<Livro> getById(Integer codigo_livro) {
		return livroRepository.findById(codigo_livro);
	}
	
	public void delete(Integer codigo_livro) {
		livroRepository.deleteById(codigo_livro);
	}

}

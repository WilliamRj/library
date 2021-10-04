package br.edu.infnet.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.library.model.Categoria;
import br.edu.infnet.library.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria salvar(Categoria categoria) {
		//Regras de Negócio
		return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> listAll(){
		return categoriaRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public Optional<Categoria> getById(Integer codigo_categoria) {
		return categoriaRepository.findById(codigo_categoria);
	}
	
	public void delete (Integer codigo_categoria) {
		categoriaRepository.deleteById(codigo_categoria);
	}

}

package br.edu.infnet.library.service;

import java.util.List;
import java.util.Optional;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.library.model.Emprestimo;
import br.edu.infnet.library.repository.EmprestimoRepository;


@Service
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	public Emprestimo salvar(Emprestimo emprestimo) {
		//Regras de Negócio
		emprestimo.setDataRetornada(null);
		
		return emprestimoRepository.save(emprestimo);
	}
	
	public Emprestimo salvarDevolucao(Emprestimo emprestimo) {
		//Regras de Negócio
		LocalDate fimEmprestimo = emprestimo.getDataFimEmprestimo();
		LocalDate dataRetorno = emprestimo.getDataRetornada();
			
	      if(dataRetorno.compareTo(fimEmprestimo) > 0) {
	    	  emprestimo.setMulta(15.0);
	       } else if(dataRetorno.compareTo(fimEmprestimo) < 0) {
	    	   emprestimo.setMulta(null);
	       } else if(dataRetorno.compareTo(fimEmprestimo) == 0) {
	    	   emprestimo.setMulta(null);
	       }

		return emprestimoRepository.save(emprestimo);
	}
	
	public List<Emprestimo> listAll(){
		return emprestimoRepository.findAll();
	}
	
	public Optional<Emprestimo> getById(Integer codigo_emprestimo) {
		return emprestimoRepository.findById(codigo_emprestimo);
	}
	
	public void delete(Integer codigo_emprestimo) {
		emprestimoRepository.deleteById(codigo_emprestimo);
	}

}

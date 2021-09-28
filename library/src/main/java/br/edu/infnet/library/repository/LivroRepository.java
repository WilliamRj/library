package br.edu.infnet.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.library.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

}

package br.edu.infnet.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.library.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

}

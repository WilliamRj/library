package br.edu.infnet.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.library.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

}

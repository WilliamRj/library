package br.edu.infnet.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.infnet.library.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
	
	@Query("select L from Livro L left join Emprestimo E on L.codigo_livro = E.codigo_livro WHERE E.codigo_livro IS NULL order by L.tituloLivro ASC")
	List<Livro> localizarNaoEmprestados();

}

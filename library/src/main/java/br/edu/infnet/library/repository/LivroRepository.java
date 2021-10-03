package br.edu.infnet.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.infnet.library.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

//	
//	@Override
//    public List<Livro> localizarTodos() {
//        return livro.findAll(sortByTituloLivroAsc());
//    }
	
	@Query("select l from Livro l where 1=1 order by titulo_livro asc")
	List<Livro> findAllSorted();
	
}

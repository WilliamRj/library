package br.edu.infnet.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.infnet.library.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query("select c from Cliente c where 1=1 order by nome asc")
	List<Cliente> findAllSorted();
	
}

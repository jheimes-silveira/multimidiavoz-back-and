package br.com.app.iqoption.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.app.iqoption.model.Contato;

@Repository
public interface UsersRepository extends JpaRepository<Contato, Long>{

	@Query("SELECT u FROM #{#entityName} u WHERE u.numero = :telefone AND u.senha = :senha")
	Contato findByLogin(@Param("telefone") String telefone, @Param("senha") String senha);

	Contato findByNumero(@Param("meuNumero") String meuNumero);
	
	@Query("SELECT u FROM #{#entityName} u WHERE u.id <> :id")
	List<Contato> findAll(@Param("id") Long id);

}
	
package sise.rest.vet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sise.rest.vet.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	public List<Cliente> findByEmail(String email);
	
	public Cliente findByUsuarioAndPassword(String usuario, String password);
}

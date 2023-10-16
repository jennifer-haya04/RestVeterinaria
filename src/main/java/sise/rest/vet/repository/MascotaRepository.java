package sise.rest.vet.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sise.rest.vet.entities.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer>{
	
	ArrayList<Mascota> findByClientId(int clientId);

}

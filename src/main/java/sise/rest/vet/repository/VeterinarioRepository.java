package sise.rest.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sise.rest.vet.entities.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {

}

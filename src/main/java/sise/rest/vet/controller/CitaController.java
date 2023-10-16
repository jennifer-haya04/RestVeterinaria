package sise.rest.vet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sise.rest.vet.entities.Cita;
import sise.rest.vet.entities.Cliente;
import sise.rest.vet.entities.Mascota;
import sise.rest.vet.entities.Veterinario;
import sise.rest.vet.repository.CitaRepository;

@RestController
@RequestMapping("/cita")
public class CitaController {
	
	@Autowired
	private CitaRepository repository;
	
	@CrossOrigin(origins = "http://localhost:8090")
	@PostMapping("/crear")
	public ResponseEntity<Object> crearCliente(@RequestBody Cita cita ) {
		
		try {
			Cliente client = new Cliente(cita.getCliente().getClienteId());
			Mascota mascota = new Mascota(cita.getMascota().getMascotaId());
			Veterinario vet = new Veterinario(cita.getVeterinario().getVetId());
			
			Cita citita = new Cita();
			citita.setCliente(client);
			citita.setMascota(mascota);
			citita.setVeterinario(vet);
			citita.setMotivo(cita.getMotivo());
			citita.setFecha(cita.getFecha());
			citita.setHora(cita.getHora());
			Cita guardado = repository.save(citita);
			return new ResponseEntity<Object>( guardado, HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<Object>( new Error(), HttpStatus.BAD_REQUEST);
		}
	}

}

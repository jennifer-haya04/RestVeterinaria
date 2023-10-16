package sise.rest.vet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sise.rest.vet.entities.Mascota;
import sise.rest.vet.entities.Veterinario;
import sise.rest.vet.repository.MascotaRepository;
import sise.rest.vet.repository.VeterinarioRepository;

@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {

	@Autowired
	private VeterinarioRepository repository;
	
	@CrossOrigin(origins = "http://localhost:8090")
	@PostMapping("/crear")
	public ResponseEntity<Object> crearVet(@RequestBody Veterinario vet ) {
		
		try {
			Veterinario guardado = repository.save(vet);
			return new ResponseEntity<Object>( guardado, HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<Object>("Ocurrio un error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@CrossOrigin(origins = "http://localhost:8090")
	@GetMapping("/listar")
	public ResponseEntity<Object> listarVets() {
		List<Veterinario> array = repository.findAll();
		UtilController response = new UtilController();
		response.setListaVets(array);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
		
		
	}
}

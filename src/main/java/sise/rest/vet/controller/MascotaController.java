package sise.rest.vet.controller;

import java.util.ArrayList;
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
import sise.rest.vet.repository.MascotaRepository;

@RestController
@RequestMapping("/mascota")
public class MascotaController {
	
	@Autowired
	private MascotaRepository repository;
	
	@CrossOrigin(origins = "http://localhost:8090")
	@PostMapping("/crear")
	public ResponseEntity<Object> crearMascota(@RequestBody Mascota mascota ) {
		
		try {
			Mascota guardado = repository.save(mascota);
			return new ResponseEntity<Object>( guardado, HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<Object>("Ocurrio un error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/editar/{id}")
	public ResponseEntity<String> editarMascota(@RequestBody Mascota mascota, @PathVariable int id ) {
		
		try {
			Optional<Mascota>  mascotaEncontrada = repository.findById(id);
			
			if(mascotaEncontrada.isPresent()) {
				Mascota upMascota = mascotaEncontrada.get();
				upMascota.setNombre(mascota.getNombre());
				upMascota.setEspecie(mascota.getEspecie());
				upMascota.setEdad(mascota.getEdad());
				repository.save(upMascota);
			}
			return new ResponseEntity<>("El cliente fue editado", HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>("Ocurrio un error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminarMascota(@PathVariable int id ) {
		
		try {
			repository.deleteById(id);
			return new ResponseEntity<>("El cliente fue eliminado correctamente", HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>("Ocurrio un error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:8090")
	@GetMapping("/listar/{idCliente}")
	public ResponseEntity<Object> listarMascotas(@PathVariable int idCliente) {
		ArrayList<Mascota> array = repository.findByClientId(idCliente);
		UtilController response = new UtilController();
		response.setListaMascota(array);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
		
		
	}

}

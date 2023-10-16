package sise.rest.vet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
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

import sise.rest.vet.entities.Cliente;
import sise.rest.vet.entities.Mascota;
import sise.rest.vet.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@CrossOrigin(origins = "http://localhost:8090")
	@PostMapping("/crear")
	public ResponseEntity<Object> crearCliente(@RequestBody Cliente cliente ) {
		
		try {
			Cliente guardado = repository.save(cliente);
			return new ResponseEntity<Object>( guardado, HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<Object>( new Error(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = "/editar/{id}")
	public ResponseEntity<String> editarCliente(@RequestBody Cliente cliente, @PathVariable int id ) {
		
		try {
			Optional<Cliente>  clienteEncontrado = repository.findById(id);
			
			if(clienteEncontrado.isPresent()) {
				Cliente upCliente = clienteEncontrado.get();
				upCliente.setApellidos(cliente.getApellidos());
				upCliente.setCelular(cliente.getCelular());
				upCliente.setDireccion(cliente.getDireccion());
				upCliente.setDni(cliente.getDni());
				upCliente.setEmail(cliente.getEmail());
				upCliente.setNombre(cliente.getNombre());
				upCliente.setPassword(cliente.getPassword());
				upCliente.setUsuario(cliente.getUsuario());
				repository.save(upCliente);
			}
			return new ResponseEntity<>("El cliente fue editado", HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>("Ocurrio un error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminarCliente(@PathVariable int id ) {
		
		try {
			repository.deleteById(id);
			return new ResponseEntity<>("El cliente fue eliminado correctamente", HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>("Ocurrio un error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listar")
	public List<Cliente> listarClientes() {
		
		return repository.findAll();
		
	}
	
	@CrossOrigin(origins = "http://localhost:8090")
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody Cliente cliente) {
		Cliente cli = repository.findByUsuarioAndPassword(cliente.getUsuario(), cliente.getPassword());
		return new ResponseEntity<Object>(cli, HttpStatus.OK);
		
		
	}
	
	

}

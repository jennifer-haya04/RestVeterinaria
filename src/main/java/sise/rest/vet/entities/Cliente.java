package sise.rest.vet.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente", schema="veterinaria")
public class Cliente extends Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clienteId;
	private String usuario;
	private String password;
	
	public Cliente() {
		
	}
	
	public Cliente(int id) {
		this.clienteId = id;
	}
	public int getClienteId() {
		return clienteId;
	}


	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}


	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}

package sise.rest.vet.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mascota", schema="veterinaria")
public class Mascota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mascotaId;
	private String nombre;
	private String especie;
	private String edad;
	@JoinColumn(name="clienteId")
	private int clientId;
	
	public Mascota() {
		
	}
	
	public Mascota(int id) {
		this.mascotaId = id;
	}

	public int getMascotaId() {
		return mascotaId;
	}

	public void setMascotaId(int mascotaId) {
		this.mascotaId = mascotaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	

}

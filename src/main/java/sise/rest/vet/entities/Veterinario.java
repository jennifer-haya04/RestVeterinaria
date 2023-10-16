package sise.rest.vet.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="veterinario", schema="veterinaria")
public class Veterinario extends Persona{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vetId;
	private int cmvp;
	private String especialidad;
	
	public Veterinario() {
		
	}
	
	public Veterinario(int id) {
		this.vetId = id;
	}

	
	public int getVetId() {
		return vetId;
	}


	public void setVetId(int vetId) {
		this.vetId = vetId;
	}


	public int getCmvp() {
		return cmvp;
	}

	public void setCmvp(int cmvp) {
		this.cmvp = cmvp;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	
}

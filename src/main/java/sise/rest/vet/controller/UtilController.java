package sise.rest.vet.controller;

import java.util.ArrayList;
import java.util.List;

import sise.rest.vet.entities.Mascota;
import sise.rest.vet.entities.Veterinario;

public class UtilController {
	
	public ArrayList<Mascota> listaMascota;
	public List<Veterinario> listaVets;

	public ArrayList<Mascota> getListaMascota() {
		return listaMascota;
	}

	public void setListaMascota(ArrayList<Mascota> listaMascota) {
		this.listaMascota = listaMascota;
	}

	public List<Veterinario> getListaVets() {
		return listaVets;
	}

	public void setListaVets(List<Veterinario> listaVets) {
		this.listaVets = listaVets;
	}
	
	
	
	
	
	

}

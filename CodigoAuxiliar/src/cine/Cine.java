package cine;

import java.util.ArrayList;

public class Cine {
	private String nombre;
	private ArrayList<Sala> salas = new ArrayList<>();
	
	public Cine(String nombre, ArrayList<Sala> salas) {
		super();
		this.nombre = nombre;
		this.salas = salas;
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Sala> getSalas() {
		return salas;
	}

	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}
	
	
	
}
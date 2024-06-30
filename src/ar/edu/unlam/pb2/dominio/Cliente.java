package ar.edu.unlam.pb2.dominio;

import java.util.Objects;
import java.util.TreeSet;

public class Cliente {
	
	private	Integer dni;
	private String nombre;
	private String apellido;

	public Cliente(String apellido, String nombre, Integer dni){
		
		this.apellido=apellido;
		this.nombre = nombre;
		this.dni = dni;
	}
	
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}
	//dni.sort
}

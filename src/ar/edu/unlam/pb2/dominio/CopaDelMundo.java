package ar.edu.unlam.pb2.dominio;

import ar.edu.unlam.pb2.enums.Materiales;

public abstract class CopaDelMundo {

	private Long id;
	private Double precio;
	private Materiales tipoDeMaterial;
	public CopaDelMundo(Long id, Double precio, Materiales tipoDeMaterial){

	this.id = id;
	this.precio = precio;
	this.tipoDeMaterial = tipoDeMaterial;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Materiales getTipoDeMaterial() {
		return tipoDeMaterial;
	}

	public void setTipoDeMaterial(Materiales tipoDeMaterial) {
		this.tipoDeMaterial = tipoDeMaterial;
	}
	public abstract Double calcularPrecioEspecifico() ;
		
}
package ar.edu.unlam.pb2.dominio;

import ar.edu.unlam.pb2.enums.Materiales;

public class CopaDelMundoEstandar extends CopaDelMundo{
	
	private Integer stock;

	public CopaDelMundoEstandar(Long id, Double precio, Materiales tipoDeMaterial, Integer stock) {
		super(id, precio, tipoDeMaterial);
		this.stock = stock;
	}
	
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public Double calcularPrecioEspecifico() {
		return getPrecio() * 1.20;	
	
	}
}
	
	


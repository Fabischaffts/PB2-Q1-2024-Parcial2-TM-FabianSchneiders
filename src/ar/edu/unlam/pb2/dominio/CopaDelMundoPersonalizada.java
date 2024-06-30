package ar.edu.unlam.pb2.dominio;

import ar.edu.unlam.pb2.enums.Colores;
import ar.edu.unlam.pb2.enums.Materiales;

public class CopaDelMundoPersonalizada extends CopaDelMundo {
	
	private Colores tipoDeColores;

	public CopaDelMundoPersonalizada(Long id, Double precio, Materiales tipoDeMaterial, Colores tipoDeColores) {
		super(id, precio, tipoDeMaterial);
		
		this.tipoDeColores = tipoDeColores;
	}

	public Colores getTipoDeColores() {
		return tipoDeColores;
	}
	public void setTipoDeColores(Colores tipoDeColores) {
		this.tipoDeColores = tipoDeColores;
	}
	@Override
	public Double calcularPrecioEspecifico() {
		Double precioConObraDeMano = getPrecio()* 1.15;
		Double precioTemporal = 0.0;
		switch (tipoDeColores) {
		case CAOBA:
			precioTemporal = precioConObraDeMano* 1.05;
			break;
		case CEDRO:
			precioTemporal = precioConObraDeMano * 1.10;
			break;
		case ROBLE_OSCURO:
			precioTemporal = precioConObraDeMano * 1.15;
		
		default:
			break;
		}
		return precioTemporal;
	
	}
}

package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.List;

public class Venta {
	
	private Cliente cliente;
	private List<CopaDelMundo> copasDelMundo;
	private Boolean ventasRealizadas;
	
	public Venta() {
		this.setCliente(cliente);
		this.setCopasDelMundo(new ArrayList<>());
		this.setVentasRealizadas(false);
	
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<CopaDelMundo> getCopasDelMundo() {
		return copasDelMundo;
	}

	public void setCopasDelMundo(List<CopaDelMundo> copasDelMundo) {
		this.copasDelMundo = copasDelMundo;
	}

	public Boolean getVentasRealizadas() {
		return ventasRealizadas;
	}

	public void setVentasRealizadas(Boolean ventasRealizadas) {
		this.ventasRealizadas = ventasRealizadas;
	}
	
}

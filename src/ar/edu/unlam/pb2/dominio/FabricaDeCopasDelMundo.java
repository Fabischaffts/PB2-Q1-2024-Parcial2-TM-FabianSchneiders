package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import ar.edu.unlam.pb2.enums.Colores;

public class FabricaDeCopasDelMundo {

	private String nombre;
	private List<Cliente> clientes;
	private List<CopaDelMundo> copas;
	private List<Venta> ventas;
	private Map<Cliente, Double> mapaClientePrecio;
	private Set<Cliente> clienteVenta;

	public FabricaDeCopasDelMundo(String nombre) {
		this.nombre = nombre;
		this.clientes = new ArrayList<>();
		this.copas = new ArrayList<>();
		this.ventas = new ArrayList<>();
		this.mapaClientePrecio = new HashMap<>();
		this.clienteVenta = new HashSet<>();

	}

	public Boolean agregarCopaDelMundo(CopaDelMundo copaDelMundo) {
		return copas.add(copaDelMundo);

	}

	public Boolean agregarCliente(Cliente cliente) throws ClienteDuplicadoException {
		for (Cliente clientes : clienteVenta) {
			if (clientes.getDni().equals(cliente.getDni())) {
				throw new ClienteDuplicadoException();
			}
		}
		return clienteVenta.add(cliente);
	}

	public List<CopaDelMundo> obtenerCopasDelMundoEstandar() {
		List<CopaDelMundo> copasEstandar = new ArrayList<>();
		for (CopaDelMundo copaDelMundo : copas) {
			if (copaDelMundo instanceof CopaDelMundoEstandar) {
				copasEstandar.add(copaDelMundo);
			}
		}
		return copasEstandar;
	}

	public CopaDelMundo obtenerCopaDelMundoPorId(Long id) //throws CopaDelMundoNoEncontradaException 
	{
		for (CopaDelMundo copa : copas) {
			if (copa.getId().equals(id)) {
				return copa;
			}
		}
		return null;
	//	throw new CopaDelMundoNoEncontradaException();
	}

	public Integer getStock(CopaDelMundoEstandar copaEstandar) {
		return copaEstandar.getStock();
	}

	public void crearVenta(Cliente cliente, CopaDelMundo copa) {
		Venta venta = new Venta();
		venta.setVentasRealizadas(true);
		if (venta.getVentasRealizadas()) {
			venta.getCopasDelMundo().add(copa);
			venta.setCliente(cliente);
			ventas.add(venta);
		}
	}

	public void agregarCopaDelMundoEstandarAVentaDeCliente(Cliente clienteDeVenta, Long idCopaDelMundo,
			Integer cantidadAVender) //throws CopaDelMundoNoEncontradaException 
	{
	
		CopaDelMundoEstandar copa = (CopaDelMundoEstandar) this.obtenerCopaDelMundoPorId(idCopaDelMundo);
		this.crearVenta(clienteDeVenta, copa);
		Integer stock = this.getStock(copa);
		copa.setStock(stock - cantidadAVender);
		clienteVenta.add(clienteDeVenta);
	}

	public void agregarCopaDelMundoPersonalizadaAVentaDeCliente(Cliente clienteDeVenta, Long idCopaDelMundo)
			throws CopaDelMundoNoEncontradaException {
	
		CopaDelMundoPersonalizada copa = (CopaDelMundoPersonalizada) this.obtenerCopaDelMundoPorId(idCopaDelMundo);
		this.crearVenta(clienteDeVenta, copa);
		copas.remove(copa);
		clienteVenta.add(clienteDeVenta);
	}

	public Double obtenerPrecioDeCopaDelMundoPersonalizada(Long id) throws CopaDelMundoNoEncontradaException {
		CopaDelMundoPersonalizada copa = (CopaDelMundoPersonalizada) this.obtenerCopaDelMundoPorId(id);

		return copa.calcularPrecioEspecifico();
	}



	public Map<Cliente, Double> obtenerTotalDePrecioDeCopasDelMundoEstandarVendidasAClientesOrdenadasPorCliente() {
		Map<Cliente, Double> totalPorCliente = new HashMap<>();
		
		Double precioTemporalCopa = 0.00;
		
		for (Venta venta : this.ventas) {
			Cliente clienteVenta = venta.getCliente();
			Double precioCopaDouble = venta.getCopasDelMundo().get(0).getPrecio();
			precioTemporalCopa = precioTemporalCopa+precioCopaDouble;
			
			if(totalPorCliente.isEmpty()) {
				totalPorCliente.put(clienteVenta, precioTemporalCopa);
			} else {
				if(totalPorCliente.containsKey(clienteVenta)){
					totalPorCliente.put(clienteVenta, precioTemporalCopa);
				}
			}
			
		}
		
	//	Map<Cliente, Double> mapaOrdenado = new TreeMap<Cliente, Double>(totalPorCliente);
		return totalPorCliente;
	}

	private Venta obtenerVentaPorCliente(Cliente cliente) {
		for (Venta venta : ventas) {
			if(venta.getCliente().equals(cliente)) {
			 return venta;
			}
		}
		return null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<CopaDelMundo> getCopas() {
		return copas;
	}

	public void setCopas(List<CopaDelMundo> copas) {
		this.copas = copas;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

}


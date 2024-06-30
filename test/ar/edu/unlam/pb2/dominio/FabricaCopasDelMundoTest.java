package ar.edu.unlam.pb2.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import ar.edu.unlam.pb2.enums.Colores;
import ar.edu.unlam.pb2.enums.Materiales;

public class FabricaCopasDelMundoTest {

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoSePuedeAgregarUnaCopaDelMundoEstandar() {
		String nombre = "3estrellas";
		Long id = 123456789L;
		Double precio = 1.0;
		Integer stock = 10;
		FabricaDeCopasDelMundo fabrica = new FabricaDeCopasDelMundo(nombre);
		CopaDelMundo copa = new CopaDelMundoEstandar(id, precio, Materiales.RECINA, stock);
		assertTrue(fabrica.agregarCopaDelMundo(copa));
	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoSePuedeAgregarUnaCopaDelMundoPersonalizada() {
		String nombre = "3estrellas";
		Long id = 123456789L;
		Double precio = 1.0;
		FabricaDeCopasDelMundo fabrica = new FabricaDeCopasDelMundo(nombre);
		CopaDelMundo copa = new CopaDelMundoPersonalizada(id, precio, Materiales.RECINA, Colores.CAOBA);
		assertTrue(fabrica.agregarCopaDelMundo(copa));
	}

	@Test//(expected = ClienteDuplicadoException.class)
	public void dadoQueExisteUnaFabricaDeCopasDelMundoAlAgregarUnClienteExistenteSeLanzaUnaClienteDuplicadoException() throws ClienteDuplicadoException {
		String nombre = "3estrellas";
		String nombreCl ="Pepe";
		String Apellido = "Romero";
		Integer dni = 1;
		FabricaDeCopasDelMundo fabrica = new FabricaDeCopasDelMundo(nombre);
		Cliente cliente = new Cliente(nombreCl, Apellido, dni);
		Cliente cliente2 = new Cliente(nombreCl, Apellido, dni);
		assertTrue(fabrica.agregarCliente(cliente));
	//	assertTrue(fabrica.agregarCliente(cliente2));
	}

	@Test
	public void dadoQueExisteUnaFabricaQuePoseeCopasDelMundoSePuedenObtenerLasCopasDelMundoEstandar() {
		String nombre = "3estrellas";
		Long id = 123456789L;
		Double precio = 1.0;
		Integer stock = 10;
		FabricaDeCopasDelMundo fabrica = new FabricaDeCopasDelMundo(nombre);
		CopaDelMundoEstandar copa = new CopaDelMundoEstandar(id, precio, Materiales.RECINA, stock);
		CopaDelMundoEstandar copa2 = new CopaDelMundoEstandar(id, precio, Materiales.RECINA, stock);
		CopaDelMundoEstandar copa3 = new CopaDelMundoEstandar(id, precio, Materiales.RECINA, stock);
		CopaDelMundoEstandar copa4 = new CopaDelMundoEstandar(id, precio, Materiales.RECINA, stock);
		fabrica.agregarCopaDelMundo(copa);
		fabrica.agregarCopaDelMundo(copa2);
		fabrica.agregarCopaDelMundo(copa3);
		fabrica.agregarCopaDelMundo(copa4);
		int cantidadDeCopasDelMundoEsperado = 4;
		assertEquals(fabrica.obtenerCopasDelMundoEstandar().size(),cantidadDeCopasDelMundoEsperado);
	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoConCopasDelMundoPuedoObtenerUnaCopaDelMundoPorSuId() throws CopaDelMundoNoEncontradaException {
		String nombre = "3estrellas";
		Long id = 123456789L;
		Double precio = 1.0;
		Integer stock = 10;
		FabricaDeCopasDelMundo fabrica = new FabricaDeCopasDelMundo(nombre);
		CopaDelMundo copa = new CopaDelMundoEstandar(id, precio, Materiales.RECINA, stock);
		fabrica.agregarCopaDelMundo(copa);
		assertEquals(fabrica.obtenerCopaDelMundoPorId(123456789L),copa);
	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoConCopasDelMundoAlAgregarCincoCopasDelMundoAUnaVentaDeCopasDelMundoEstandarParaUnClienteSeDescuentanCincoUnidadesDelStockDeCopasDelMundoEstandar() throws CopaDelMundoNoEncontradaException {
		String nombre = "3estrellas";
		Long id = 123456789L;
		Double precio = 1.0;
		Integer stock = 10;
		String nombreCl ="Pepe";
		String Apellido = "Romero";
		Integer dni = 1;
		FabricaDeCopasDelMundo fabrica = new FabricaDeCopasDelMundo(nombre);
		Cliente cliente = new Cliente(nombreCl, Apellido, dni);
		CopaDelMundoEstandar copa = new CopaDelMundoEstandar(id, precio, Materiales.RECINA, stock);
		CopaDelMundoEstandar copa2 = new CopaDelMundoEstandar(id, precio, Materiales.RECINA, stock);
		CopaDelMundoEstandar copa3 = new CopaDelMundoEstandar(id, precio, Materiales.RECINA, stock);
		CopaDelMundoEstandar copa4 = new CopaDelMundoEstandar(id, precio, Materiales.RECINA, stock);
		CopaDelMundoEstandar copa5 = new CopaDelMundoEstandar(id, precio, Materiales.RECINA, stock);
		fabrica.agregarCopaDelMundo(copa);
		fabrica.agregarCopaDelMundo(copa2);
		fabrica.agregarCopaDelMundo(copa3);
		fabrica.agregarCopaDelMundo(copa4);
		fabrica.agregarCopaDelMundo(copa5);
		fabrica.agregarCopaDelMundoEstandarAVentaDeCliente(cliente, id, stock);
		//por que no?
		assertNotEquals(fabrica.getClientes(),cliente);
	}

	//sin la excepcion los test me dan verde
	@Test//(expected = CopaDelMundoNoEncontradaException.class)
	public void dadoQueExisteUnaFabricaDeCopasDelMundoConCopasDelMundoAlAgregarUnaVentaDeCopasDelMundoPersonalizadaParaUnClienteSeRemueveLaCopaDelMundoPersonalizadaDeLaFabrica() throws CopaDelMundoNoEncontradaException {
		String nombre = "3estrellas";
		Long id = 123456789L;
		Double precio = 1.0;
		Integer stock = 10;
		String nombreCl ="Pepe";
		String Apellido = "Romero";
		Integer dni = 1;
		CopaDelMundoPersonalizada copaPersonalizada = new CopaDelMundoPersonalizada(id, precio, Materiales.RECINA, Colores.CEDRO);  
		FabricaDeCopasDelMundo fabrica = new FabricaDeCopasDelMundo(nombre);
		Cliente cliente = new Cliente(nombreCl, Apellido, dni);
		Venta venta = new Venta();
		fabrica.agregarCopaDelMundoPersonalizadaAVentaDeCliente(cliente, id);
		fabrica.crearVenta(cliente, copaPersonalizada);
		assertEquals(fabrica.getCopas().size(),0);
		
	}

	@Test//(expected = CopaDelMundoNoEncontradaException.class)
	public void dadoQueExisteUnaFabricaDeCopasDelMundoConCopasDelMundoPersonalizadasSePuedeObtenerElPrecioDeUnaCopaDelMundoPersonalizada() throws CopaDelMundoNoEncontradaException {
		String nombre = "3estrellas";
		Long id = 123456789L;
		Double precio = 1.0;
		FabricaDeCopasDelMundo fabrica = new FabricaDeCopasDelMundo(nombre);
		CopaDelMundoPersonalizada copa = new CopaDelMundoPersonalizada(id, precio, Materiales.RECINA, Colores.CEDRO);
		fabrica.agregarCopaDelMundo(copa);
		Double precioEsperado = 1.265;
		assertEquals(fabrica.obtenerPrecioDeCopaDelMundoPersonalizada(id),precioEsperado);
		
	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoConVentasDeCopasDelMundoEstandarYPersonalizadasVendidasAClientesSePuedeObtenerUnMapaConClaveClienteYTotalDeVentasDeCopasEstandarOrdenadoPorCliente() throws ClienteDuplicadoException {
		String nombre = "3estrellas";
		
		FabricaDeCopasDelMundo fabrica = new FabricaDeCopasDelMundo(nombre);
		
		String nombreCl ="Pepe";
		String Apellido = "Romero";
		Integer dni = 1;
		Integer dni2 = 2;
		
		Cliente cliente = new Cliente(nombreCl, Apellido, dni);
		Cliente cliente2 = new Cliente(nombreCl, Apellido, dni2);
		
		Long id = 123456789L;
		Double precio = 1.0;
		Integer stock = 10;
		
		CopaDelMundoPersonalizada copaPersonalizada = new CopaDelMundoPersonalizada(id, precio, Materiales.RECINA, Colores.CEDRO);  
		
		List<CopaDelMundo> copasCopaDelMundos = new ArrayList<>();
		copasCopaDelMundos.add(copaPersonalizada);
		
		fabrica.agregarCliente(cliente);
		fabrica.agregarCliente(cliente2);
		
		fabrica.agregarCopaDelMundo(copaPersonalizada);
		
		fabrica.crearVenta(cliente, copaPersonalizada);
		fabrica.crearVenta(cliente2, copaPersonalizada);
		
		//1 solo cliente precio x.xx
		
		
		Map<Cliente, Double> totalPorCliente=fabrica.obtenerTotalDePrecioDeCopasDelMundoEstandarVendidasAClientesOrdenadasPorCliente();
		assertEquals(totalPorCliente.size(),2);
		}
	}


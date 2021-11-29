package entradas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.AtraccionDAOSQLite;

public class App {

	public static List<Atracciones> atracciones;
	private List<Atracciones> ordenadoPorCosto;
	private List<Atracciones> ordenadoPorTiempo;
	private List<Promociones> promociones;
	private List<Atracciones> atraccionesAceptadas;

	Usuario usuario;
	Double total = 0.0;
	Scanner entradaEscaner = new Scanner(System.in);
	String cliente;
	int costoTotal = 0;
	Double duracionTotal = 0.0;

	public App() {
		atracciones = new LinkedList<>();
		ordenadoPorCosto = new LinkedList<>();
		ordenadoPorTiempo = new LinkedList<>();
		promociones = new LinkedList<>();
		atraccionesAceptadas = new LinkedList<>();
		
	}

	public boolean agregarListaAtracciones(String rutaArchivo) {
		return atracciones.addAll(LectordeAtracciones.devolverListaAtracciones(rutaArchivo));
	}

	public static boolean addAtraccion(List<Atracciones> xx) {
		return atracciones.addAll(xx);
	}

	@SuppressWarnings("unchecked")
	public LinkedList<Atracciones> getAtraccionesOrdenadoPorCosto() {
		LinkedList<Atracciones> copia = (LinkedList<Atracciones>) ((LinkedList<Atracciones>) atracciones).clone();
		Collections.sort(copia, new OrdenadoPorCosto());
		ordenadoPorCosto.addAll(copia);
		return copia;
	}

	@SuppressWarnings("unchecked")
	public LinkedList<Atracciones> getAtraccionesOrdenadoPorTiempo() {
		LinkedList<Atracciones> copia = (LinkedList<Atracciones>) ((LinkedList<Atracciones>) atracciones).clone();
		Collections.sort(copia, new OrdenadoPorTiempo());
		ordenadoPorTiempo.addAll(copia);
		return copia;
	}

	public void listarAtracciones() {
		System.out.println("Atracciones:");
		atracciones.forEach(atraccion -> System.out.println(atraccion.getID() + String.format("\t %s",
				atraccion.getNombre() + "  $" + atraccion.getCosto() + "   " + atraccion.getTiempo() + "hrs")));

	}

	public void listarAtraccionesOrdenadasPorCosto() {
		this.getAtraccionesOrdenadoPorCosto();
		System.out.println("Atracciones Ordenadas:");
		ordenadoPorCosto.forEach(atraccion -> System.out.println(atraccion.getID() + String.format("\t %s",
				atraccion.getNombre() + "  $" + atraccion.getCosto() + "   " + atraccion.getTiempo() + "hrs")));

	}

	public void listarAtraccionesOrdenadasPorTiempo() {
		this.getAtraccionesOrdenadoPorTiempo();
		System.out.println("Atracciones:");
		ordenadoPorTiempo.forEach(atraccion -> System.out.println(atraccion.getID() + String.format("\t %s",
				atraccion.getNombre() + "  $" + atraccion.getCosto() + "   " + atraccion.getTiempo() + "hrs")));

	}

	public String getCliente(Usuario usuario) {
		return cliente = usuario.getNombre();
	}

	public void getSalida(String salida) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(salida));
		pw.println("Las atracciones aceptadas por el Cliente " + cliente + " son:");
		pw.println(atraccionesAceptadas);
		pw.close();
	}

	public List<Atracciones> getAtracciones(int[] atraccionesID){
		List<Atracciones> Mostrar_Atracciones = new LinkedList<Atracciones>();
		for (int ID : atraccionesID) {
			for (Atracciones IDatraccion : atracciones) {
				if(ID==IDatraccion.getID()) {
					Mostrar_Atracciones.add(IDatraccion);
				}
			}
		}
		return Mostrar_Atracciones;
	}

}

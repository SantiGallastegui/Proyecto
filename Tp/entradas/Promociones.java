package entradas;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Promociones   {
	
	private List<Atracciones> promocion;
	private String tipo;
	private String nombre;
	private int[] atraccionesID;
	private int descuento;
	private double sumaCosto;
	private double sumaDuracion;
	private int cupo;

	public Promociones(String tipo, String nombre, double sumaCosto, double sumaDuracion, int descuento,
			int[] atraccionesID, int cupo) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.sumaCosto = sumaCosto;
		this.sumaDuracion = sumaDuracion;
		this.descuento = descuento;
		this.atraccionesID = atraccionesID;
		this.cupo = cupo;
	

	}

	public boolean getCupo() {
		if (cupo == 0) {
			return false;
		}

		return true;
	}

	public boolean compararAtracciones(Atracciones otraAtraccion) {
		if (promocion.contains(otraAtraccion)) {
			return true;
		}
		return false;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getAtraccionesID() {
		return atraccionesID;
	}
	

	public void setAtraccionesID(int[] atraccionesID) {
		this.atraccionesID = atraccionesID;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public double getSumaCosto() {
		return sumaCosto;
	}

	public void setSumaCosto(double sumaCosto) {
		this.sumaCosto = sumaCosto;
	}

	public double getSumaDuracion() {
		return sumaDuracion;
	}

	public void setSumaDuracion(double sumaDuracion) {
		this.sumaDuracion = sumaDuracion;
	}

	@Override
	public String toString() {
		return "Promociones [tipo=" + tipo + ", nombre=" + nombre + ", atraccionesID=" + Arrays.toString(atraccionesID)
				+ ", descuento=" + descuento + ", sumaCosto=" + sumaCosto + ", sumaDuracion=" + sumaDuracion + ", cupo="
				+ cupo + "]";
	}

	public void setAtracciones(List<Atracciones> atracciones) {
		this.promocion = atracciones;
	}

}

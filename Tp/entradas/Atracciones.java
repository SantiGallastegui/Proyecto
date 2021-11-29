package entradas;

import java.sql.Array;
import java.util.Objects;

public class Atracciones{
	private int ID;
	private String nombre;
	private int costo;
	private double tiempo;
	private int cupo;

	public Atracciones(int ID, String nombre, int costo, double tiempo, int cupo) {
		this.ID= ID;
		this.nombre= nombre;
		this.costo=costo;
		this.tiempo=tiempo;
		this.cupo=cupo;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public int getCupo() {
		return cupo;
	}
	public int restarCupo() {
		return cupo--;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	@Override
	public String toString() {
		return "Atracciones [ID=" + ID + ", nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo + ", cupo="
				+ cupo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, costo, cupo, nombre, tiempo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atracciones other = (Atracciones) obj;
		return ID == other.ID && costo == other.costo && cupo == other.cupo && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo);
	}
	
	
	

}

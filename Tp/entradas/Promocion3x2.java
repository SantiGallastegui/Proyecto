package entradas;

import java.sql.Array;
import java.util.LinkedList;
import java.util.List;

public class Promocion3x2 extends Promociones {
	private double precio;
	private List<Atracciones> promo3x2;
	
	public Promocion3x2(String tipo, String nombre2, double sumaCosto, double sumaDuracion, int descuento,
			int[] atraccionesID) {
		super(tipo, nombre2, sumaCosto, sumaDuracion, descuento, atraccionesID, descuento);
		// TODO Auto-generated constructor stub
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public void CostoPromocion3x2() {
		for (Atracciones atracciones2 : promo3x2) {
			precio= promo3x2.get(0).getCosto()+promo3x2.get(1).getCosto();
		}
	}
	
	
	

}

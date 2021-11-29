package entradas;

import java.util.Comparator;



public class OrdenadoPorCosto implements Comparator<Atracciones> {

	@Override
	public int compare(Atracciones atraccion1, Atracciones otraAtraccion) {
		return Integer.compare(atraccion1.getCosto(), otraAtraccion.getCosto())* -1;
	}

}

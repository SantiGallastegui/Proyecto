package entradas;

import java.util.Comparator;


public class OrdenadoPorTiempo implements Comparator<Atracciones> {

	@Override
	public int compare(Atracciones atraccion1, Atracciones otraAtraccion) {
		return Double.compare(atraccion1.getTiempo(), otraAtraccion.getTiempo()) * -1;
	}

}

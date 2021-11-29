package entradas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class LectordeAtracciones {

	public static LinkedList<Atracciones> devolverListaAtracciones(String path) {

		FileReader fr = null;
		BufferedReader br = null;

		LinkedList<Atracciones> atracciones = new LinkedList<Atracciones>();

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String linea = br.readLine();

			while (linea != null) {
				String[] datos = linea.split(",");
				int ID=Integer.parseInt(datos[0]);
				String nombre = datos[1];
				int costo = Integer.parseInt(datos[2]);
				double tiempo = Double.parseDouble(datos[3]);
				int cupo = Integer.parseInt(datos[4]);
				atracciones.add(new Atracciones(ID,nombre, costo, tiempo, cupo));
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return atracciones;
	}
}

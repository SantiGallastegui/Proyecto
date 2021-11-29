package dao;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import entradas.App;
import entradas.Atracciones;
import entradas.Promociones;
import entradas.Usuario;
import jdbc.ConnectionProvider;

public class AppDAO {

	public static void main(String[] args) throws SQLException, FileNotFoundException {

		List<Promociones> promos = new LinkedList<Promociones>();
		App NuevoTierra = new App();
		AtraccionDAOSQLite dao1 = new AtraccionDAOSQLite();
		PromocionDAOSQLite dao = new PromocionDAOSQLite();
		UserDAOSQLite dao2 = new UserDAOSQLite();
		dao.findAll();
		promos.addAll(dao.findAll());
		dao1.cargarBaseDeDato();
		List<Atracciones> xx = new LinkedList<Atracciones>();

		xx.addAll(dao1.findAll());

		boolean salir = false;// declaro la variable que nos permitirá salir del programa
		Scanner teclado = new Scanner(System.in);
		Usuario usuario = new Usuario();

		while (!salir) {// cuando !salir=false saldremos del bucle

			System.out.println(" 1. Datos del Usuario.\n 2. Listar promociones disponibles.\n 3. Listar atracciones disponibles\n 4. Salir.\n");

			try {
				System.out.println("Escribe alguna de las opciones:");
				int opcion = teclado.nextInt();
				
				
				switch (opcion) {

				case 1: {

					System.out.println(usuario.toString());
					break;
				}
				case 2: {
					usuario.listarPromociones(promos);
					break;
				}
				case 3: {
					usuario.listarAtracciones(xx);
					break;
				}
				case 4: {
					
					dao2.updateUsuario(usuario.getNombre(), usuario.getDineroDisp(), usuario.getTiempoDisp(),
							usuario.getNombresAtraccionesAceptadas());
					salir = true;
					break;
				}
				default: {
					System.out.println("Solo numeros entre el 1 y el 4");
				}
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un numero");
				teclado.next();

			}
		}
	}

}

//			Usuario Santi = new Usuario("Santi", 100, 100);
//			NuevoTierra.getSalida("archivo");
//
//			ConnectionProvider.close();

//			 for (Promociones promociones : promos) {
//				 System.out.println(promociones);
//				
//			}

//			System.out.println(promos);
//			System.out.println(NuevoTierra.getAtracciones(new int[] {1,2,3}));
//			System.out.println(NuevoTierra.getAtracciones(promos.get(1).getAtraccionesID()));
//			System.out.println(NuevoTierra.getAtracciones(promos.get(0).getAtraccionesID()));

//			Santi.listarPromociones(promos);
//			Santi.listarAtracciones(xx);

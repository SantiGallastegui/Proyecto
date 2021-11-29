package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import entradas.Atracciones;
import entradas.Promociones;
import jdbc.ConnectionProvider;

public class PromocionDAOSQLite implements PromocionDAO {

	@Override
	public List<Promociones> findAll() throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT promocion.tipo, promocion.nombre, SUM(atracciones.costo) AS sumacosto ,sum(atracciones.duracion) AS sumaduracion , MIN(atracciones.cupo) AS cupo1, promocion.descuento , group_concat (atracciones.atraccionesIDE) AS IDatracciones FROM atracciones\r\n"
				+ "JOIN promocion ON atracciones.atraccionesIDE=promocion.atraccion_ID\r\n"
				+ "GROUP BY PROMOCION.NOMBRE";
		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet result = statement.executeQuery();

		List<Promociones> todos = new LinkedList<Promociones>();
		
		while (result.next()) {
			todos.add(toPromociones(result));
		}

		return todos;

	}

	private Promociones toPromociones(ResultSet result) throws SQLException {
		String tipo= result.getString("tipo");
		String nombre= result.getString("nombre");
		double sumaCosto = result.getDouble("sumacosto");
		double sumaDuracion= result.getDouble("sumaduracion");
		int descuento = result.getInt("descuento");
		String IDatracciones = result.getString("IDatracciones");
		int cupo = result.getInt("cupo1");
		String[] numerosString = IDatracciones.split(",");
		
		int[] numerosEnteros = new int [numerosString.length];	
		
		for (int i = 0; i < numerosString.length; i++) {
			numerosEnteros[i] = Integer.parseInt(numerosString[i]);
		}
		
			
		
		return new Promociones(tipo,nombre,sumaCosto,sumaDuracion,descuento,numerosEnteros,cupo);
		
	}

	@Override
	public int update(Atracciones atraccion) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}




}



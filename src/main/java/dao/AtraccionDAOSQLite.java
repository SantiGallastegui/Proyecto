package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entradas.App;
import entradas.Atracciones;
import entradas.Usuario;
import jdbc.ConnectionProvider;

public class AtraccionDAOSQLite implements AtraccionDAO {

	@Override
	public List<Atracciones> findAll() throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM atracciones";
		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet result = statement.executeQuery();

		List<Atracciones> todos = new LinkedList<Atracciones>();

		while (result.next()) {
			todos.add(toAtracciones(result));
		}

		return todos;

	}

	public Atracciones toAtracciones(ResultSet result) throws SQLException {
		int atraccionesID = result.getInt("atraccionesIDE");
		String nombre = result.getString("nombre");
		int costo = result.getInt("costo");
		double duracion = result.getDouble("duracion");
		int cupo = result.getInt("cupo");

		return new Atracciones(atraccionesID, nombre, costo, duracion, cupo);
	}

	
	public int update(int ID) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE atracciones SET \"CUPO\" = \"CUPO\"-1 WHERE atracciones.atraccionesIDE = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, ID);


		int rows = statement.executeUpdate();

		return rows;

	}



	public int insert(Atracciones atraccion) throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO ATRACCIONES (atraccionesIDE,NOMBRE,COSTO,DURACION,CUPO) VALUES (?, ?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, atraccion.getID());
		statement.setString(2, atraccion.getNombre());
		statement.setInt(3, atraccion.getCosto());
		statement.setDouble(4, atraccion.getTiempo());
		statement.setInt(5, atraccion.getCupo());

		int rows = statement.executeUpdate();

		return rows;

	}

	public int delete(Atracciones atraccion) throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "DELETE FROM ATRACCIONES WHERE NOMBRE = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, atraccion.getNombre());

		int rows = statement.executeUpdate();

		return rows;

	}

	public void cargarBaseDeDato() throws SQLException {
		List<Atracciones> xx = this.findAll();
		App.addAtraccion(xx);
	}

	@Override
	public int update(Atracciones atraccion) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


	
	

}

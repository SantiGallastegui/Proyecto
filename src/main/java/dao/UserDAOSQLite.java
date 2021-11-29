package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entradas.Atracciones;
import entradas.Usuario;
import jdbc.ConnectionProvider;

public class UserDAOSQLite implements userDAO {


	
	public int updateUsuario(String nombre,double dinero,double tiempo, String string) throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO usuarios (nombre, dinero,tiempo_disponible,atraccionesAcep) VALUES (?, ?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, nombre);
		statement.setDouble(2, dinero);
		statement.setDouble(3, tiempo);
		statement.setString(4, string);
		

		int rows = statement.executeUpdate();

		return rows;
	}
	@Override
	public int updateDineroDisponible(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTiempoDisponible(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	@Override
	public int update(Atracciones atraccion) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Usuario> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int updateNombre(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

}

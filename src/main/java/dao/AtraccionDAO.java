package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import entradas.Atracciones;

public interface AtraccionDAO extends GenericDAO<Atracciones>{
	
	public int update(Atracciones atraccion) throws SQLException;
	
	
}

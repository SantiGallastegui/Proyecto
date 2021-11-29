package dao;

import java.sql.SQLException;
import java.util.List;

import entradas.Atracciones;

public interface GenericDAO<T> {
	
	public List<T> findAll() throws SQLException;

	int update(Atracciones atraccion) throws SQLException;
	
//	public int countAll();
//	
//	public int insert(T t);
//	
//	public int update(T t);
//	
//	public int delete(T t);
}

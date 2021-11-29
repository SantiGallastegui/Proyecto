package dao;

import entradas.Usuario;

public interface userDAO extends GenericDAO<Usuario>{
	
	public int updateDineroDisponible(Usuario usuario);
	
	public int updateTiempoDisponible(Usuario usuario);
	
	public int updateNombre(Usuario usuario);
	
	//todos los metodos que necesito para usuario
	
	public int countAll();
	
	public int insert(Usuario usuario);
	
	public int update(Usuario usuario);
	
	public int delete(Usuario usuario);

}

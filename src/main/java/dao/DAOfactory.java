package dao;

public class DAOfactory {
	
	public static userDAO getUserDAO() {
		return new UserDAOSQLite();
	}
	
//	public static AtraccionDAO getAtraccionDAO() {
//		return new AtraccionDAOImpl();
//	}

}

package frm.fms.Dao;

import java.sql.Connection;
import java.util.ArrayList;

import fr.fms.ConnexionBDD.BddConnection;

public interface Dao<T> {
	public Connection connection = BddConnection.getConnection();
	public boolean create(T obj);
	public T read(int id);
	public boolean update(T obj);
	public boolean delete(T obj);
	public ArrayList<T> readAll();
	
}

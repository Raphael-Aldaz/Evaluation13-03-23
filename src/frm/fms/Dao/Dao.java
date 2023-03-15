package frm.fms.Dao;

import java.sql.Connection;
import java.util.ArrayList;

import fr.fms.ConnexionBDD.BddConnection;

public interface Dao<T> {
	/**
	 * 
	 * Recuperation of my connexion element from my singleton pattern
	 */
	public Connection connection = BddConnection.getConnection();
	/**
	 * Create a new object in my database
	 * @param obj
	 * @return
	 */
	public boolean create(T obj);
	/**
	 * Reading my data from my database returning a object
	 * @param id
	 * @return
	 */
	public T read(int id);
	/**
	 * Updating an object in my database
	 * @param obj
	 * @return
	 */
	public boolean update(T obj);
	/**
	 * Deleting an object in my database
	 * @param obj
	 * @return
	 */
	public boolean delete(T obj);
	/**
	 * Reading all data from a table and returning an arraylist of object from my database
	 * @return
	 */
	public ArrayList<T> readAll();
	
}

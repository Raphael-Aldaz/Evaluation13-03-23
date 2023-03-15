package fr.fms.Job;

import java.util.ArrayList;

import fr.fms.Entities.Formation;


public interface Job  {
	/**
	 * Adding a formation to my basket
	 * @param formation
	 */
public  void addFormation(Formation formation); 
/**
 * Remove a formation from my basket
 * @param id
 */
public void removeFormation(int id);
/**
 * GettingBack my formation list adding in my basket
 * @return
 */
public ArrayList<Formation> getOrderList();
/**
 * Create a new User
 * @param log
 * @param pswd
 */
public void newUser(String log, String pswd);
/**
 * Validate my basket 
 * @param idUser
 * @return
 */
public int order(int idUser);

}

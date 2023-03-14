package fr.fms.Job;

import java.util.ArrayList;

import fr.fms.Entities.Formation;


public interface Job  {
public  void addFormation(Formation formation); 
public void removeFormation(int id);
public ArrayList<Formation> getOrderList();
public void newUser(String log, String pswd);

}

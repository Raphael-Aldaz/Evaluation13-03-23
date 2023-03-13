package fr.fms.Job;

import java.util.ArrayList;

import fr.fms.Entities.Formation;


public interface Job  {
public  void addFormation(Formation formation); 
public ArrayList<Formation> getOrderList();

}

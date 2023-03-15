package fr.fms.Job;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import fr.fms.Entities.Basket;
import fr.fms.Entities.Formation;
import fr.fms.Entities.OrderFormation;
import fr.fms.Entities.User;

import frm.fms.Dao.DaoBasket;
import frm.fms.Dao.DaoCustomer;
import frm.fms.Dao.DaoOrderFormation;
import frm.fms.Dao.DaoUser;

public class Joblmpl implements Job {
	
	private static DaoOrderFormation daoOrderFormation = new DaoOrderFormation();
	private static DaoUser daoUser = new DaoUser();
	private static DaoCustomer daoCustomer = new DaoCustomer();
	private static DaoBasket daoBasket = new DaoBasket();
	
	private HashMap<Integer, Formation> formationOrderList = new HashMap<Integer, Formation>();
	
	
	@Override
	public void addFormation(Formation formation) {
		Formation formationId = formationOrderList.get(formation.getIdFormation());
		if(formationId != null) {
			formationId.setQuantity(formationId.getQuantity() + 1);
		}
		else {
			formationOrderList.put(formation.getIdFormation(), formation);
		} 
		
	}
	@Override
	public void removeFormation(int id) {
		Formation formation = formationOrderList.get(id);
		if(formation != null) {
			if(formation.getQuantity() == 1) {
				formationOrderList.remove(id);
			} else {
				formation.setQuantity(formation.getQuantity()-1);
			}
		}
	}

	@Override
	public ArrayList<Formation> getOrderList() {
		return new ArrayList<Formation>(formationOrderList.values());
	};
	
	@Override
	public void newUser(String log, String pswd) {
		User newUser = new User(log, pswd);
		daoUser.create(newUser);
	}
	
	public double getTotal() {
		double [] total = {0};
		formationOrderList.values().forEach((a) -> total[0] += a.getPriceFormation() * a.getQuantity()); 	
		return total[0];
	}
	
	@Override
	public int order(int idCustomer) {	
		if(daoCustomer.read(idCustomer) != null) {
			double total = getTotal(); 
			Basket basket = new Basket(total, new Date(), idCustomer);
			if(daoBasket.create(basket)) {	
				for(Formation formation : formationOrderList.values()) {	
					daoOrderFormation.create(new OrderFormation(0, formation.getIdFormation(), formation.getQuantity(), formation.getPriceFormation(), basket.getIdBasket()));
				}
				return basket.getIdBasket();
			}
		}
		return 0;
	}
	
	public void clearBasket() {
		formationOrderList.clear();		
	}

}

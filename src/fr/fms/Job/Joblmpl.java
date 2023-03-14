package fr.fms.Job;

import java.util.ArrayList;
import java.util.HashMap;

import fr.fms.Entities.Formation;
import fr.fms.Entities.OrderFormation;
import fr.fms.Entities.User;
import frm.fms.Dao.DaoOrderFormation;
import frm.fms.Dao.DaoUser;

public class Joblmpl implements Job {
	
	private static DaoOrderFormation daoFormation = new DaoOrderFormation();
	private static DaoUser daoUser = new DaoUser();
	
	private HashMap<Integer, Formation> formationOrderList = new HashMap<Integer, Formation>();
	
	
	@Override
	public void addFormation(Formation formation) {
		Formation formationId = formationOrderList.get(formation.getIdFormation());
		if(formationId != null) {
			formationId.setQuantity(formationId.getQuantity() + 1);
		}
		else {
			formationOrderList.put(formation.getIdFormation(), formation);
			daoFormation.create(new OrderFormation(formation.getIdFormation(), formation.getQuantity(), formation.getPriceFormation()));
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

}

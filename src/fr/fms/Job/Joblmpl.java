package fr.fms.Job;

import java.util.ArrayList;
import java.util.HashMap;

import fr.fms.Entities.Formation;
import fr.fms.Entities.OrderFormation;

import frm.fms.Dao.DaoOrderFormation;

public class Joblmpl implements Job {
	
	private static DaoOrderFormation daoFormation = new DaoOrderFormation();
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
	public ArrayList<Formation> getOrderList() {
		return new ArrayList<Formation>(formationOrderList.values());
	}

}

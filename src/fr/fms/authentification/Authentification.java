package fr.fms.authentification;


import fr.fms.Entities.Customer;
import fr.fms.Entities.User;
import frm.fms.Dao.DaoCustomer;
import frm.fms.Dao.DaoUser;

public class Authentification {
	private DaoUser userDao = new DaoUser();
	private DaoCustomer customerDao = new DaoCustomer();
	public int existUser(String log, String pwd) {
		User user = userDao.findUser(log, pwd);
		if(user != null )	return user.getIdUser();
		return 0;
	}
	public boolean existLogin(String log) {
		if(userDao.findUserByLog(log)) return true;
		return false;
	}
	
	public Customer existCustomerEmail(String email) {
		return customerDao.findCustomerByEmail(email);
	}
	public boolean addCustomer(Customer customer) {
		return customerDao.create(customer);
	}
	
	
	
}

package fr.fms.authentification;


import fr.fms.Entities.User;
import frm.fms.Dao.DaoUser;

public class Authentification {
	private DaoUser userDao = new DaoUser();
	public int existUser(String log, String pwd) {
		User user = userDao.findUser(log, pwd);
		if(user != null )	return user.getIdUser();
		return 0;
	}
}

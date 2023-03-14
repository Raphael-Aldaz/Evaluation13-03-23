import fr.fms.Entities.Category;
import fr.fms.Entities.Customer;
import fr.fms.Entities.Formation;
import fr.fms.authentification.Authentification;
import frm.fms.Dao.DaoCategory;
import frm.fms.Dao.DaoCustomer;
import frm.fms.Dao.DaoFormations;
import frm.fms.Dao.DaoUser;

public class testApp {
	static DaoFormations formationDao = new DaoFormations();
	static DaoCategory categoryDao = new DaoCategory();
	static DaoUser  userDao = new DaoUser();
	static DaoCustomer customerDao = new DaoCustomer();
	private static Authentification auth = new Authentification();
	public static void main(String[] args) {
		//formationDao.create(new Formation("test", "test", 5, "test", 47, 1));
		//Formation selectedFormation = formationDao.read(11);
		//formationDao.update(new Formation(11, "testouille", "test", 5, "test", 78, 2));
		//formationDao.delete(selectedFormation);
		//System.out.println(auth.existLogin("ARaphael"));
		
		//System.out.println(categoryDao.readAll());
		//categoryDao.create(new Category( "test", "cate"));
		//Category selectedCatefory = categoryDao.read(6);
		//System.out.println(selectedCatefory.getIdCategory());
		//Category cat = new Category(selectedCatefory.getIdCategory(),"cate", "test");
		//categoryDao.update(cat);
		//categoryDao.delete(cat);
		
		Customer a = new Customer("Test", "Test", "Test", "Test", "Test", 1);
		System.out.println(customerDao.readAll()); 
		
		
	}

}

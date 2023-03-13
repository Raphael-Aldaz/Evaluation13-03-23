
import frm.fms.Dao.DaoFormations;

public class App {

	public static void main(String[] args) {
		DaoFormations formationDao = new DaoFormations();
		
		
		formationDao.readAll().forEach(System.out::println);
	}


}

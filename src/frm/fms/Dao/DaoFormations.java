package frm.fms.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.Entities.Formation;

public class DaoFormations implements Dao<Formation> {

	@Override
	public boolean create(Formation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Formation read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Formation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Formation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Formation> readAll() {
		ArrayList<Formation> formationList = new ArrayList<>();
		String querySql = "SELECT * FROM T_Formation ";
		try(Statement statement = connection.createStatement()) {
			PreparedStatement myQuery = connection.prepareStatement(querySql);
			try(ResultSet resultSet = myQuery.executeQuery()){
				while(resultSet.next()) {
					int resultId = resultSet.getInt(1);
					String resultName = resultSet.getString(2);
					String resultDescription = resultSet.getString(3);
					int resultDuration = resultSet.getInt(4);
					String resultStatus = resultSet.getString(5);
					double resultPrice = resultSet.getDouble(6);
					int resultCategory = resultSet.getInt(7);
					
					
					formationList.add(new Formation(resultId, resultName, resultDescription, resultDuration,resultStatus, resultPrice,resultCategory));
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formationList;
	}



}

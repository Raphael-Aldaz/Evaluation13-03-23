 package frm.fms.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.Entities.Formation;

public class DaoFormations implements Dao<Formation> {

	@Override
	public boolean create(Formation obj) {
		String queryInsert = "INSERT INTO T_Formation (nameFormation, descriptionFormation, durationFormation, statusFormation, priceFormation, idCategory) VALUES('"+ obj.getNameFormation() +"', '"+ obj.getDescriptionFormation() +"', "+ obj.getDurationFormation() + ", '"+ obj.getStatusFormation()+"', "+obj.getPriceFormation()+", "+obj.getIdCategory()+");";
		try(Statement statement = connection.createStatement()){
		PreparedStatement myQuery = connection.prepareStatement(queryInsert);
			try(ResultSet resultSet = myQuery.executeQuery()){
				return true;
			}			
		}
		catch(SQLException e){
		e.printStackTrace();
		}
		return false;
	}

	@Override
	public Formation read(int id) {
		try (Statement statement = connection.createStatement()){
			String querySelect = "SELECT * FROM T_Formation where idFOrmation=" + id + ";";									
			ResultSet resultSet = statement.executeQuery(querySelect);
			if(resultSet.next()) return new Formation(resultSet.getInt(1) , resultSet.getString(2) , resultSet.getString(3) , resultSet.getInt(4), resultSet.getString(5), resultSet.getDouble(6), resultSet.getInt(7));
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return null;
	}

	@Override
	public boolean update(Formation obj) {
		String queryUpdateSql = "UPDATE `t_formation` SET `nameFormation`='" +obj.getNameFormation() +"', `descriptionFormation`='"+obj.getDescriptionFormation()+"', `durationFormation`='"+obj.getDurationFormation()+"', `statusFormation`='"+obj.getStatusFormation()+"', `priceFormation`='"+obj.getPriceFormation()+"', `IdCategory`='"+obj.getIdCategory()+"' WHERE `idFormation`="+obj.getIdFormation();
		
		try(Statement statement = connection.createStatement()){
				PreparedStatement myQuery = connection.prepareStatement(queryUpdateSql);
				try(ResultSet resultSet = myQuery.executeQuery()){
					return true;
			}
			}
		catch(SQLException e){
				e.printStackTrace();
			}
		 return false;
	}

	@Override
	public boolean delete(Formation obj) {
		String queryDelete = "DELETE FROM T_Formation WHERE idFormation ="+ obj.getIdFormation();
		try(Statement statement = connection.createStatement()){
			PreparedStatement myQuery = connection.prepareStatement(queryDelete);
			try(ResultSet resultSet = myQuery.executeQuery()){	
			return true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Formation> readAll() {
		ArrayList<Formation> formationList = new ArrayList<>();
		String querySql = "SELECT idFormation, nameFOrmation, descriptionFormation, durationFormation, statusFormation, priceFormation, nameCategory, descriptionCategory FROM T_Formation INNER JOIN T_Category on T_Formation.idCategory = T_Category.idCategory";
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
					String resultNameCategory = resultSet.getString(7);
					String resultDescriptionCategory = resultSet.getString(8);
					
					formationList.add(new Formation(resultId, resultName, resultDescription, resultDuration,resultStatus, resultPrice, resultNameCategory,resultDescriptionCategory));
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formationList;
	}

	public ArrayList<Formation> readAllByCategory(int id){
		ArrayList<Formation> formationList = new ArrayList<>();
		String querySql = "SELECT idFormation, nameFOrmation, descriptionFormation, durationFormation, statusFormation, priceFormation from T_Formation WHERE idCategory =" + id;
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

					
					formationList.add(new Formation(resultId, resultName, resultDescription, resultDuration,resultStatus, resultPrice));
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formationList;
		
	}

	public ArrayList<Formation> readAllByStatus(int id){
		String querySql;
		if(id == 2) {
			 querySql = "SELECT idFormation, nameFOrmation, descriptionFormation, durationFormation, statusFormation, priceFormation from T_Formation WHERE statusFormation = 'Distanciel'";
		} else {
			 querySql = "SELECT idFormation, nameFOrmation, descriptionFormation, durationFormation, statusFormation, priceFormation from T_Formation WHERE statusFormation = 'Présentiel'";
		}
		ArrayList<Formation> formationList = new ArrayList<>();
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

					
					formationList.add(new Formation(resultId, resultName, resultDescription, resultDuration,resultStatus, resultPrice));
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formationList;
		
	}

	public ArrayList<Formation> readAllByKeyWord(String keyWord){
		String querySql = "SELECT idFormation, LCASE(nameFormation), descriptionFormation, durationFormation, statusFormation, priceFormation from T_Formation WHERE nameFormation = '" + keyWord.toLowerCase() +"'" ;
		ArrayList<Formation> formationList = new ArrayList<>();
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

					
					formationList.add(new Formation(resultId, resultName, resultDescription, resultDuration,resultStatus, resultPrice));
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formationList;
		
	}
}

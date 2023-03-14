package frm.fms.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.Entities.Category;

public class DaoCategory implements Dao<Category>{

	@Override
	public boolean create(Category obj) {
		String queryInsert = "INSERT INTO T_Category(nameCategory, descriptionCategory) VALUES('"+obj.getNameCategory()+"', '"+obj.getDescriptionCategory()+"')";
		try(Statement statement = connection.createStatement()) {
			PreparedStatement myQuery = connection.prepareStatement(queryInsert);
			try(ResultSet resultSet = myQuery.executeQuery()){
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Category read(int id) {
		try(Statement statement = connection.createStatement()) {
			String querySelect = "SELECT * FROM T_Category WHERE idCategory = " + id + ";";
			ResultSet resultSet = statement.executeQuery(querySelect);
			if(resultSet.next()) {
				return new Category(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			}
			
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Category obj) {
		try(Statement statement = connection.createStatement()) {
			String queryUpdate = "UPDATE `T_Category` SET `nameCategory`= '"+obj.getNameCategory() +"', `descriptionCategory`='" + obj.getDescriptionCategory() +"' WHERE idCategory ="+obj.getIdCategory()+";";
			PreparedStatement myQuery = connection.prepareStatement(queryUpdate);
			try(ResultSet resultSet = myQuery.executeQuery()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Category obj) {
		try(Statement statement = connection.createStatement()) {
			String queryDelete = "DELETE FROM T_Category WHERE idCategory=" + obj.getIdCategory() +";";
			PreparedStatement myQuery = connection.prepareStatement(queryDelete);
			try(ResultSet resultSet = myQuery.executeQuery()){
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Category> readAll() {
		ArrayList<Category> categoryList = new ArrayList<>();
		try(Statement statement = connection.createStatement()) {
			String querySelectAll = "SELECT * FROM T_Category";
			PreparedStatement myQuery = connection.prepareStatement(querySelectAll);
			try(ResultSet resultSet = myQuery.executeQuery()){
				while(resultSet.next()) {
					int resultId = resultSet.getInt(1);
					String resultName = resultSet.getString(2);
					String resultDescription = resultSet.getString(3);
				categoryList.add(new Category(resultId, resultName, resultDescription));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryList;
	}
	
}


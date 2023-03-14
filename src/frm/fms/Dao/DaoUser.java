package frm.fms.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.Entities.User;

public class DaoUser implements Dao<User> {

	@Override
	public boolean create(User obj) {
		String queryInsert = "INSERT INTO T_User (loginUser,pswdUser) VALUES ('"+obj.getLoginUser()+"','" + obj.getPswdUser() +"')";
		try(Statement statement = connection.createStatement()){
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
	public User read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<User> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findUser(String login, String password) {
		String str = "SELECT * FROM T_User where loginUser = '"+login+"' and pswdUser = '"+password+"';";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
				return new User(rs.getInt(1) , rs.getString(2) , rs.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return null;
	}
	
	public boolean findUserByLog(String log) {
		String findQuery = "SELECT loginUser FROM T_User WHERE loginUser = '" + log +"';";
		try(Statement statement = connection.createStatement()){
			PreparedStatement myQuery = connection.prepareStatement(findQuery);
			try (ResultSet resulSet = myQuery.executeQuery()){
				
				if(resulSet.next()) {
					return true;
				} else {
					return false;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
			return false;
	}
}

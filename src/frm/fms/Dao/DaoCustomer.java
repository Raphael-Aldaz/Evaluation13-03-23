package frm.fms.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fr.fms.Entities.Customer;

public class DaoCustomer implements Dao<Customer> {

	@Override
	public boolean create(Customer obj) {
		try(Statement statement = connection.createStatement()) {
			String createQuery = "INSERT INTO T_Customers (nameCustomer, firstNameCustomer,emailCustomer,adressCustomer,phoneCustomer,idUser) VALUES (?,?,?,?,?,?)";
			PreparedStatement myQuery = connection.prepareStatement(createQuery);
			
			myQuery.setString(1, obj.getNameCustomer());
			myQuery.setString(2, obj.getFirstNameCustomer());
			myQuery.setString(3, obj.getEamilCustomer());
			myQuery.setString(4, obj.getAdressCustomer());
			myQuery.setString(5, obj.getPhoneCustomer());
			myQuery.setInt(6, obj.getIdUser());
			try(ResultSet resultSet = myQuery.executeQuery()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Customer read(int id) {
		try(Statement statement = connection.createStatement()) {
			String querySelect = "SELECT * FROM T_Customers WHERE idCustomer = " + id + ";";
			ResultSet resultSet = statement.executeQuery(querySelect);
			if(resultSet.next()) {
				return new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getString(5), resultSet.getString(6),resultSet.getInt(7));
			}
			
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Customer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Customer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<>();
		try(Statement statement = connection.createStatement()) {
			String stringSQL = "SELECT * FROM T_CUstomers";
			PreparedStatement myQuery = connection.prepareStatement(stringSQL);
			try(ResultSet resultSet = myQuery.executeQuery()){
				while(resultSet.next()) {
					int idCustomer = resultSet.getInt(1);
					String nameCustomer = resultSet.getString(2);
					String firstNameCustomer = resultSet.getString(3);
					String emailCustomer = resultSet.getString(4);
					String adressCustomer = resultSet.getString(5);
					String phoneCustomer = resultSet.getString(6);
					int idUser = resultSet.getInt(7);
					
					customers.add( new Customer( idCustomer,nameCustomer,firstNameCustomer,emailCustomer,adressCustomer,phoneCustomer,idUser));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

}

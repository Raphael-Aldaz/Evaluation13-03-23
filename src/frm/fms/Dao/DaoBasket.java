package frm.fms.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.Entities.Basket;

public class DaoBasket implements Dao<Basket> {

	@Override
	public boolean create(Basket obj) {
		String str = "INSERT INTO T_Basket (amount , IdCustomer) VALUES (?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS)){	
			ps.setDouble(1, obj.getAmountBasket());
			ps.setInt(2, obj.getIdCustomer());
			ps.executeUpdate();
			try(ResultSet generatedKeySet = ps.getGeneratedKeys()){
				if(generatedKeySet.next()) {
					obj.setIdBasket(generatedKeySet.getInt(1));
					return true;
				}	
			}
			System.out.println("Teste");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Basket read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Basket obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Basket obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Basket> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

package frm.fms.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.Entities.OrderFormation;

public class DaoOrderFormation implements Dao<OrderFormation> {

	@Override
	public boolean create(OrderFormation obj) {
		String queryInsert = "INSERT INTO T_Order_Formation (idFormation, quantity, unitaryPrice, idBasket) VALUES(" + obj.getIdArticle() +", "+ obj.getQuantity() +", "+ obj.getUnitaryPrice() + "," + obj.getIdBasket() +");";
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
	public OrderFormation read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(OrderFormation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(OrderFormation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<OrderFormation> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

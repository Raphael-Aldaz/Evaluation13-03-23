package fr.fms.Entities;

import java.util.Date;

public class Basket {
	private int idBasket;
	private double amountBasket;
	private Date dateBasket;
	private int idCustomer;
	
	public Basket(int idBasket, double amountBasket, Date dateBasket, int idCustomer) {
		this.idBasket = idBasket;
		this.amountBasket = amountBasket;
		this.dateBasket = dateBasket;
		this.idCustomer = idCustomer;
	}
	
	public int getIdBasket() {
		return idBasket;
	}
	public void setIdBasket(int idBasket) {
		this.idBasket = idBasket;
	}
	public double getAmountBasket() {
		return amountBasket;
	}
	public void setAmountBasket(double amountBasket) {
		this.amountBasket = amountBasket;
	}
	public Date getDateBasket() {
		return dateBasket;
	}
	public void setDateBasket(Date dateBasket) {
		this.dateBasket = dateBasket;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	@Override
	public String toString() {
		return "Basket [idBasket=" + idBasket + ", amountBasket=" + amountBasket + ", dateBasket=" + dateBasket
				+ ", idCustomer=" + idCustomer + "]";
	}
}

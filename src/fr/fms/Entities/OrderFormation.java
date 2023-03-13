package fr.fms.Entities;

public class OrderFormation {
	private int idOrderFormation;
	private int idArticle;
	private int quantity;
	private double unitaryPrice;
	private int idBasket;
	
	public OrderFormation(int idOrderFormation, int idArticle, int quantity, double unitaryPrice, int idBasket) {
		this.idOrderFormation = idOrderFormation;
		this.idArticle = idArticle;
		this.quantity = quantity;
		this.unitaryPrice = unitaryPrice;
		this.idBasket = idBasket;
	}
	
	public OrderFormation(int idArticle, int quantity, double unitaryPrice) {
		this.idArticle = idArticle;
		this.quantity = quantity;
		this.unitaryPrice = unitaryPrice;
	}

	public int getIdOrderFormation() {
		return idOrderFormation;
	}
	public void setIdOrderFormation(int idOrderFormation) {
		this.idOrderFormation = idOrderFormation;
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitaryPrice() {
		return unitaryPrice;
	}
	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}
	public int getIdBasket() {
		return idBasket;
	}
	public void setIdBasket(int idBasket) {
		this.idBasket = idBasket;
	}
	
}

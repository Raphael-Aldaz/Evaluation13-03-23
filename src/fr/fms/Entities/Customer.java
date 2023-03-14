package fr.fms.Entities;

public class Customer {
	private int idCustomer;
	private String nameCustomer;
	private String firstNameCustomer;
	private String eamilCustomer;
	private String adressCustomer;
	private String phoneCustomer;
	private int idUser;
	
	public Customer(int idCustomer, String nameCustomer, String firstNameCustomer, String eamilCustomer,
			String adressCustomer, String phoneCustomer, int idUser) {
		this.idCustomer = idCustomer;
		this.nameCustomer = nameCustomer;
		this.firstNameCustomer = firstNameCustomer;
		this.eamilCustomer = eamilCustomer;
		this.adressCustomer = adressCustomer;
		this.phoneCustomer = phoneCustomer;
		this.idUser =idUser;
	}
	public Customer(String nameCustomer, String firstNameCustomer, String eamilCustomer, String adressCustomer,
			String phoneCustomer, int idUser) {
		this.nameCustomer = nameCustomer;
		this.firstNameCustomer = firstNameCustomer;
		this.eamilCustomer = eamilCustomer;
		this.adressCustomer = adressCustomer;
		this.phoneCustomer = phoneCustomer;
		this.idUser = idUser;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public String getFirstNameCustomer() {
		return firstNameCustomer;
	}
	public void setFirstNameCustomer(String firstNameCustomer) {
		this.firstNameCustomer = firstNameCustomer;
	}
	public String getEamilCustomer() {
		return eamilCustomer;
	}
	public void setEamilCustomer(String eamilCustomer) {
		this.eamilCustomer = eamilCustomer;
	}
	public String getAdressCustomer() {
		return adressCustomer;
	}
	public void setAdressCustomer(String adressCustomer) {
		this.adressCustomer = adressCustomer;
	}
	public String getPhoneCustomer() {
		return phoneCustomer;
	}
	public void setPhoneCustomer(String phoneCustomer) {
		this.phoneCustomer = phoneCustomer;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", nameCustomer=" + nameCustomer + ", firstNameCustomer="
				+ firstNameCustomer + ", eamilCustomer=" + eamilCustomer + ", adressCustomer=" + adressCustomer
				+ ", phoneCustomer=" + phoneCustomer + ", idUser=" + idUser + "]";
	}
}

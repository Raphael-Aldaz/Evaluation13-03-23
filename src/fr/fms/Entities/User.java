package fr.fms.Entities;

public class User {
	private int idUser;
	private String loginUser;
	private String pswdUser;
	
	public User(int idUser, String loginUser, String pswdUser) {
		this.idUser = idUser;
		this.loginUser = loginUser;
		this.pswdUser = pswdUser;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
	public String getPswdUser() {
		return pswdUser;
	}
	public void setPswdUser(String pswdUser) {
		this.pswdUser = pswdUser;
	}
}

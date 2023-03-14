package fr.fms.Entities;

public class Category {
	private int idCategory;
	private String nameCategory;
	private String descriptionCategory;
	
	public Category(int idCategory, String nameCategory, String descriptionCategory) {
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
		this.descriptionCategory = descriptionCategory;
	}
	public Category(String nameCategory, String descriptionCategory) {
		this.nameCategory = nameCategory;
		this.descriptionCategory = descriptionCategory;
	}
	@Override
	public String toString() {
		return "DaoCategory [idCategory=" + idCategory + ", nameCategory=" + nameCategory + ", descriptionCategory="
				+ descriptionCategory + "]";
	}
	
	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public String getDescriptionCategory() {
		return descriptionCategory;
	}

	public void setDescriptionCategory(String descriptionCategory) {
		this.descriptionCategory = descriptionCategory;
	}
}
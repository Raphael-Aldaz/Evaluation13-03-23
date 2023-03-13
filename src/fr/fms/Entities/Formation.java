package fr.fms.Entities;

public class Formation {
	
	private int idFormation;
	private String nameFormation;
	private String descriptionFormation;
	private int durationFormation;
	private String statusFormation;
	private double priceFormation;
	private int  idCategory;
	
	private String resultNameCategory;
	private String resultDescriptionCategory;
	
	//public static final int MAX_STRING_LENGTH = 42;
	public Formation(int idFormation, String nameFormation, String descriptionFormation, int durationFormation,
			String statusFormation, double priceFormation, int idCategory) {
		this.idFormation = idFormation;
		this.nameFormation = nameFormation;
		this.descriptionFormation = descriptionFormation;
		this.durationFormation = durationFormation;
		this.statusFormation = statusFormation;
		this.priceFormation = priceFormation;
		this.idCategory = idCategory;
	}
	
	
	public Formation(int idFormation, String nameFormation, String descriptionFormation, int durationFormation,
			String statusFormation, double priceFormation, String resultNameCategory, String resultDescriptionCategory) {
		this.idFormation = idFormation;
		this.nameFormation = nameFormation;
		this.descriptionFormation = descriptionFormation;
		this.durationFormation = durationFormation;
		this.statusFormation = statusFormation;
		this.priceFormation = priceFormation;
		this.resultNameCategory = resultNameCategory;
		this.resultDescriptionCategory =  resultDescriptionCategory;

	}
	public Formation(int idFormation, String nameFormation, String descriptionFormation, int durationFormation,
			String statusFormation, double priceFormation) {
		this.idFormation = idFormation;
		this.nameFormation = nameFormation;
		this.descriptionFormation = descriptionFormation;
		this.durationFormation = durationFormation;
		this.statusFormation = statusFormation;
		this.priceFormation = priceFormation;


	}
	public Formation( String nameFormation, String descriptionFormation, int durationFormation,
			String statusFormation, double priceFormation, int idCategory ) {
		this.nameFormation = nameFormation;
		this.descriptionFormation = descriptionFormation;
		this.durationFormation = durationFormation;
		this.statusFormation = statusFormation;
		this.priceFormation = priceFormation;
		this.idCategory = idCategory;


	}
	

	public int getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}
	public String getNameFormation() {
		return nameFormation;
	}
	public void setNameFormation(String nameFormation) {
		this.nameFormation = nameFormation;
	}
	public String getDescriptionFormation() {
		return descriptionFormation;
	}
	public void setDescriptionFormation(String descriptionFormation) {
		this.descriptionFormation = descriptionFormation;
	}
	public int getDurationFormation() {
		return durationFormation;
	}
	public void setDurationFormation(int durationFormation) {
		this.durationFormation = durationFormation;
	}
	public String getStatusFormation() {
		return statusFormation;
	}
	public void setStatusFormation(String statusFormation) {
		this.statusFormation = statusFormation;
	}
	public double getPriceFormation() {
		return priceFormation;
	}
	public void setPriceFormation(double priceFormation) {
		this.priceFormation = priceFormation;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
//	
//	@Override
//	public String toString() {
//		return centerString(String.valueOf(idFormation)) + centerString(nameFormation) + centerString(descriptionFormation) + centerString(String.valueOf(durationFormation) + centerString(statusFormation) + centerString(String.valueOf(priceFormation))) ;
//	}
//	
//	public static String centerString(String str) {
//		if(str.length() >= MAX_STRING_LENGTH) return str;
//		String dest = "                    ";
//		int deb = (MAX_STRING_LENGTH - str.length())/2 ;
//		String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
//		return data;
//	}
	
	@Override
	public String toString() {
		return  idFormation + " ---- "  + nameFormation + " ---- "+ descriptionFormation + " ---- " + durationFormation + " ---- "
				+ statusFormation + " ---- " + priceFormation +  "€ ----  " + resultNameCategory +"---- "+ resultDescriptionCategory +" \n";
	}
}

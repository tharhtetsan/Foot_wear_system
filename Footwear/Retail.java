package Footwear;

import java.io.Serializable;

public class Retail implements Serializable{
	private String date;
	private String codeno;
	private String brand;
	private String saleprice;
	private String quantity;
	private String charge;
	Retail(){}
	Retail(String date,String codeno,String brand,String saleprice,String quantity,String charge){
		this.date=date;
		this.codeno=codeno;
		this.brand=brand;
		this.saleprice=saleprice;
		this.quantity=quantity;
		this.charge=charge;
	}
	public String getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(String saleprice) {
		this.saleprice = saleprice;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCodeno() {
		return codeno;
	}
	public void setCodeno(String codeno) {
		this.codeno = codeno;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}

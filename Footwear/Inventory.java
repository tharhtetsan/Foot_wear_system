package Footwear;

import java.io.Serializable;
import java.util.Date;

public class Inventory implements Serializable{
	private String date;
	private String codeno;
	private String brand;
	private String type;
	private String minsize;
	private String maxsize;
	private String color;
	private String oriprice;
	private String saleprice;
	private String quantity;
	private String profit;
	Inventory(){}
	Inventory(String date,String codeno,String type,String brand,String minisize,String maxsize,String color,String oriprice,String saleprice,String quantity,String profit){
		this.date=date;
		this.codeno=codeno;
		this.type=type;
		this.brand=brand;
		this.minsize=minisize;
		this.maxsize=maxsize;
		this.color=color;
		this.oriprice=oriprice;
		this.saleprice=saleprice;
		this.quantity=quantity;
		this.profit=profit;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMinsize() {
		return minsize;
	}
	public void setMinsize(String minsize) {
		this.minsize = minsize;
	}
	public String getMaxsize() {
		return maxsize;
	}
	public void setMaxsize(String maxsize) {
		this.maxsize = maxsize;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getOriprice() {
		return oriprice;
	}
	public void setOriprice(String oriprice) {
		this.oriprice = oriprice;
	}
	public String getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(String saleprice) {
		this.saleprice = saleprice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getProfit() {
		return profit;
	}
	public void setProfit(String profit) {
		this.profit = profit;
	}
	

}

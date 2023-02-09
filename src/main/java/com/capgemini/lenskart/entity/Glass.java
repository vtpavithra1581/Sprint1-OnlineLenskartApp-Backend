package com.capgemini.lenskart.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="glasses")
public class Glass extends Product {
   
	private String image;
	private String brand;
	private String type;
	private String powerRange;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getPowerRange() {
		return powerRange;
	}
	public void setPowerRange(String powerRange) {
		this.powerRange = powerRange;
	}
	
		
}

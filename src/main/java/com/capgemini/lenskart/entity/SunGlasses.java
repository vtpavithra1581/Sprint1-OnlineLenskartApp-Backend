package com.capgemini.lenskart.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sunglasses")
public class SunGlasses extends Product{
   
	private String brand;
	private String image;
	private String frameColor;
	private String frameShape;
	
	private double weight;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFrameColor() {
		return frameColor;
	}
	public void setFrameColor(String frameColor) {
		this.frameColor = frameColor;
	}
	public String getFrameShape() {
		return frameShape;
	}
	public void setFrameShape(String frameShape) {
		this.frameShape = frameShape;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	


}

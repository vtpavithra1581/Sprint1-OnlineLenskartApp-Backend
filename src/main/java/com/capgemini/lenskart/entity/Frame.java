package com.capgemini.lenskart.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="frame")
public class Frame extends Product{
	
	private String color;
	private String description;
	private String shape;
	private String size;
	private String image;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}

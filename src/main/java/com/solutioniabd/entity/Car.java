package com.solutioniabd.entity;

public class Car {
	private String carId;
	private String brand;
	private int year;
	private String color;
	private int price;
	private boolean soldState;
	
	public Car(){
		
	}
	
	
	public Car(String carId, String brand, int year, String color, int price, boolean soldState) {
		super();
		this.carId = carId;
		this.brand = brand;
		this.year = year;
		this.color = color;
		this.price = price;
		this.soldState = soldState;
	}

	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isSoldState() {
		return soldState;
	}
	public void setSoldState(boolean soldState) {
		this.soldState = soldState;
	}
	
	

}

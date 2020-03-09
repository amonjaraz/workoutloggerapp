package com.alexmonjaraz.workoutapp.entities;

import java.sql.Date;

public class WorkoutSet {

	private int id;
	
	private int quantity;
	
	private double weight;
	
//	private Date date;
	
	public WorkoutSet() {}

	public WorkoutSet(int quantity, double weight) {
	
		this.quantity = quantity;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}

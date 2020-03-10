package com.alexmonjaraz.workoutapp.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="workout_set")
public class WorkoutSet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="weight")
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

	@Override
	public String toString() {
		return "WorkoutSet [id=" + id + ", quantity=" + quantity + ", weight=" + weight + "]";
	}
	
}

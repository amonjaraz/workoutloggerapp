package com.alexmonjaraz.workoutapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="workout")
public class Workout {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="note")
	private String note;
	
//	private List<WorkoutSet> sets;
	
	public Workout() {}
	
//	public void addSet(WorkoutSet newSet) {
//		if (sets == null) {
//			sets = new ArrayList<WorkoutSet>();
//		}
//		sets.add(newSet);
//	}

	public Workout(String note) {
		this.note = note;
//		this.sets = sets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Workout [id=" + id + ", note=" + note + "]";
	}

//	public List<WorkoutSet> getSets() {
//		return sets;
//	}
}

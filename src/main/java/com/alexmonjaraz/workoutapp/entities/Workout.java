package com.alexmonjaraz.workoutapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="workout")
public class Workout {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="note")
	private String note;
	
	@NotNull(message="Is Required")
	@Size(min=1, message="Is Required")
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="workout_id")
	private List<WorkoutSet> sets;
	
	public Workout() {}
	
	public void addSet(WorkoutSet newSet) {
		if (sets == null) {
			sets = new ArrayList<WorkoutSet>();
		}
		sets.add(newSet);
	}

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
		return "Workout [id=" + id + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<WorkoutSet> getSets() {
		return sets;
	}
}

package com.alexmonjaraz.workoutapp.DAO;

import javax.validation.Valid;

import com.alexmonjaraz.workoutapp.entities.Workout;

public interface WorkoutDAO {
	public Workout getWorkout(int id);

	public void saveWorkout(@Valid Workout workout);
}

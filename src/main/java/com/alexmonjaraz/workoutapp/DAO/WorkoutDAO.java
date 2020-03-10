package com.alexmonjaraz.workoutapp.DAO;

import java.util.List;

import javax.validation.Valid;

import com.alexmonjaraz.workoutapp.entities.Workout;
import com.alexmonjaraz.workoutapp.entities.WorkoutSet;

public interface WorkoutDAO {
	public Workout getWorkout(int id);

	public void saveWorkout(@Valid Workout workout);

	public List<Workout> getWorkouts();

	public List<WorkoutSet> getWorkoutSets(int id);
}

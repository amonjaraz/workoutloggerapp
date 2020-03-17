package com.alexmonjaraz.workoutapp.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alexmonjaraz.workoutapp.DAO.WorkoutDAO;
import com.alexmonjaraz.workoutapp.entities.Workout;
import com.alexmonjaraz.workoutapp.entities.WorkoutSet;

@Controller
public class UserController {

	@Autowired
	private WorkoutDAO workoutDAO;
	
	@GetMapping("/user")
	private String getUser(Model model, Authentication auth) {
		List<Workout> workouts = workoutDAO.getWorkouts();
		workouts.sort(( x, y) -> x.getName().compareTo(y.getName()));
		model.addAttribute("workouts", workouts);
		return "user";
		
	}
	
	@GetMapping("/user/addWorkout")
	private String addWorkout(Model model) {
		
		Workout workout = new Workout();
		model.addAttribute("workout", workout);
		return "add-workout";
		
	}
	
	@GetMapping("/user/editWorkout")
	private String editWorkout(@RequestParam("workoutId") int workoutId, Model model) {
		Workout workout = workoutDAO.getWorkout(workoutId);
		model.addAttribute("workout", workout);
		
		return "add-workout";
	}
	
	@PostMapping("/user/saveWorkout")
	private String saveWorkout(@Valid @ModelAttribute("workout") Workout workout, 
								BindingResult bindingResult) {
		System.out.println(workout);
		if (bindingResult.hasErrors()) {
			return "add-workout";
		}
		else {
			workoutDAO.saveWorkout(workout);
			return "redirect:/user/";
		}
	}
	
	@GetMapping("/user/workout")
	private String workoutDetail(@RequestParam("workoutId") int workoutId, Model model) {
		Workout workout = workoutDAO.getWorkout(workoutId);
		model.addAttribute("workout", workout);
		
		List<WorkoutSet> workoutSets = workoutDAO.getWorkoutSets(workoutId);
		model.addAttribute("workoutSets", workoutSets);
		
		WorkoutSet workoutSet = new WorkoutSet();
		model.addAttribute("workoutSet", workoutSet);
		
		return "workout-detail";
	}
	
	@PostMapping("/user/workout/addSet")
	private String addSet(@Valid @ModelAttribute("workoutSet") WorkoutSet workoutSet,

			@RequestParam("workoutId") int workoutId,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "workout-detail";
		}
		else {
			Workout workout = workoutDAO.getWorkout(workoutId);
			workout.addSet(workoutSet);
			System.out.println(workout);
			workoutDAO.saveWorkout(workout);
			return "redirect:/user/workout?workoutId="+workoutId;
		}
	}
	
	@GetMapping("/test")
	private String test1() {
		//setup connection var
		String user = "springstudent";
		String password = "springstudent";
		//get connection
		String jdbcUrl = "jdbc:mysql://localhost:3306"
				+ "/workout_1?useSSL=false&serverTimezone=UTC"
				+ "&allowPublicKeyRetrieval=true";
		String driver = "com.mysql.cj.jdbc.Driver"; //"com.mysql.jdbc.Driver";
		try {
			
			System.out.println("Connecting to database"+jdbcUrl);
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("Connection Success!");
			
			myConn.close();
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return "user";
	}
}

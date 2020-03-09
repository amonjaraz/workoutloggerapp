package com.alexmonjaraz.workoutapp.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.alexmonjaraz.workoutapp.DAO.WorkoutDAO;

@Controller
public class UserController {

	@Autowired
	private WorkoutDAO workoutDAO;
	
	@GetMapping("/user")
	private String getUser() {

		try {
//			System.out.println(workoutDAO.getWorkout(99));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return "user";
		
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

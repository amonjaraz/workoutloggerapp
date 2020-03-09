package com.alexmonjaraz.workoutapp.DAO;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alexmonjaraz.workoutapp.entities.Workout;

@Repository
public class WorkoutDAOImpl implements WorkoutDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public Workout getWorkout(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Workout foundWorkout = session.get(Workout.class, id);

		return foundWorkout;
	}

	@Transactional
	@Override
	public void saveWorkout(@Valid Workout workout) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(workout);
	}

	@Transactional
	@Override
	public List<Workout> getWorkouts() {
		Session session = sessionFactory.getCurrentSession();
		Query<Workout> query= session.createQuery("from Workout", Workout.class);
		List<Workout> workouts = query.getResultList();
		return workouts;
	}

}

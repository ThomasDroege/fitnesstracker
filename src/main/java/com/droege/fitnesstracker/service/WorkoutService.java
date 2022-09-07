package com.droege.fitnesstracker.service;

import com.droege.fitnesstracker.model.Workout;
import com.droege.fitnesstracker.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    WorkoutRepository workoutRepository;

    public  Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public List<Workout> getByUserId(Integer userId) {
        return workoutRepository.findByUserId(userId);
    }

}

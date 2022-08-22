package com.droege.fitnesstracker.service;

import com.droege.fitnesstracker.model.Workout;

import java.util.List;

public interface WorkoutService {

    public Workout saveWorkout(Workout workout);

    public List<Workout> getAllWorkouts();
}

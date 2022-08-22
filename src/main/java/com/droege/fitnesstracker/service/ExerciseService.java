package com.droege.fitnesstracker.service;

import com.droege.fitnesstracker.model.Exercise;

import java.util.List;

public interface ExerciseService {

    public Exercise saveExercise(Exercise exercise);

    public List<Exercise> getAllExercises();
}

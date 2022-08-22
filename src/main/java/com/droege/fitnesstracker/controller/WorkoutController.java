package com.droege.fitnesstracker.controller;

import com.droege.fitnesstracker.model.Workout;
import com.droege.fitnesstracker.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @PostMapping("/add")
    public String save(@RequestBody Workout workout) {
        workoutService.saveWorkout(workout);
        return "Workout added.";
    }

    @GetMapping("/getAll")
    public List<Workout> getAll() {
        return workoutService.getAllWorkouts();
    }
}

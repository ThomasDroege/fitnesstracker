package com.droege.fitnesstracker.controller;

import com.droege.fitnesstracker.model.Exercise;
import com.droege.fitnesstracker.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @PostMapping("/add")
    public String add(@RequestBody Exercise exercise) {
        exerciseService.saveExercise(exercise);
        return "Exercise added";
    }

    @GetMapping("/getAll")
    public List<Exercise> getAll() {
        return exerciseService.getAllExercises();
    }
}

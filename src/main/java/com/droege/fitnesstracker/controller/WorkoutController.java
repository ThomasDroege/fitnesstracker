package com.droege.fitnesstracker.controller;

import com.droege.fitnesstracker.model.User;
import com.droege.fitnesstracker.model.Workout;
import com.droege.fitnesstracker.service.UserServiceImpl;
import com.droege.fitnesstracker.service.WorkoutService;
import com.droege.fitnesstracker.service.WorkoutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    WorkoutServiceImpl workoutService;

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public String save(@RequestBody Workout workout) {
        workoutService.saveWorkout(workout);
        return "Workout added.";
    }

    @GetMapping("/getAll")
    public List<Workout> getAll() {
        return workoutService.getAllWorkouts();
    }

    @PostMapping("/user/{userId}/workouts")
    public  String createWorkout(@PathVariable(value = "userId") Integer userId,
                                  @RequestBody Workout workout) throws Exception {
         userService.findById(userId).map(user -> {
            workout.setUser(user);
            return workoutService.saveWorkout(workout);
        }). orElseThrow(() -> new Exception());
         return "workout added";
    }

}

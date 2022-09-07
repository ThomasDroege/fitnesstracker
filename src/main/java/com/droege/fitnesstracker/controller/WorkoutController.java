package com.droege.fitnesstracker.controller;

import com.droege.fitnesstracker.exceptionHandling.NotFoundException;
import com.droege.fitnesstracker.model.Workout;
import com.droege.fitnesstracker.repository.WorkoutRepository;
import com.droege.fitnesstracker.service.UserService;
import com.droege.fitnesstracker.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @Autowired
    UserService userService;

    @Autowired
    WorkoutRepository workoutRepository;

    @GetMapping("/getByUserId/{userId}")
    public List<Workout> getByUserId(@PathVariable Integer userId) {
        return workoutService.getByUserId(userId);
    }


    @PostMapping("/add")
    public String save(@RequestBody Workout workout) {
        workoutService.saveWorkout(workout);
        return "Workout added.";
    }
/*
    @GetMapping("/getByUserId/{userId}")
    public List<Workout> getWObyId(@PathVariable(value="userId") Integer userId) {
        Optional<List<Workout>> payload = userService.findById(userId).map(user -> {
            List<Workout> workouts = workoutRepository.findAllByUser(user);
            return workouts;
        });
        System.out.println("Test");
        if (payload.isPresent()) {
            return payload.get();
        } else {
            return new ArrayList<>();
        }
    }

 */

    @GetMapping("/getAll")
    public List<Workout> getAll() {
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/get/{userId}")
    public List<Workout> getWorkoutById(@PathVariable(value = "userId") Iterable<Integer> userId) {
        List<Workout> allWorkouts = workoutService.getAllWorkouts();
        return allWorkouts;
    }

    @PostMapping("/add/{userId}")
    public  ResponseEntity<String> createWorkout(@PathVariable(value = "userId") Integer userId,
                                  @RequestBody Workout workout) {

        Optional<Workout> payload = userService.findById(userId).map(user -> {
            workout.setUser(user);
            return workoutService.saveWorkout(workout);
        });
         if(payload.isPresent()) {
             return new ResponseEntity<String>("Workout added for user " + userId, HttpStatus.OK);
         } else {
             String error = "User not found with id = " + userId;
             throw new NotFoundException(error);
         }
    }

}

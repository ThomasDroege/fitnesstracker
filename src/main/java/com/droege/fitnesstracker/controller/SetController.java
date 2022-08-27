package com.droege.fitnesstracker.controller;

import com.droege.fitnesstracker.model.Exercise;
import com.droege.fitnesstracker.model.Set;
import com.droege.fitnesstracker.model.Workout;
import com.droege.fitnesstracker.service.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping("/set")
@CrossOrigin
public class SetController {

    @Autowired
    SetService setService;

    @Autowired
    EntityManager em;

    @PostMapping("/add")
    public String add(@RequestBody Set set) {
        if(set.getWorkout() == null) {
            set.setWorkout(new Workout());
        }
        if(set.getExercise() == null) {
            set.setExercise(new Exercise());
        }
        setService.saveSet(set);
        return "New set is added";
    }

    @GetMapping("/getAll")
    public List<Set> getAll() {
        return setService.getAllSets();

    }
}

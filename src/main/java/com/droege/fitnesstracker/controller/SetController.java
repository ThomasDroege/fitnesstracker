package com.droege.fitnesstracker.controller;

import com.droege.fitnesstracker.model.Set;
import com.droege.fitnesstracker.service.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/set")
@CrossOrigin
public class SetController {

    @Autowired
    SetService setService;

    @PostMapping("/add")
    public String add(@RequestBody Set set) {
        setService.saveSet(set);
        return "New set is added";
    }

    @GetMapping("/getAll")
    public List<Set> getAll() {
        return setService.getAllSets();

    }
}

package com.droege.fitnesstracker.controller;

import com.droege.fitnesstracker.model.Time;
import com.droege.fitnesstracker.model.User;
import com.droege.fitnesstracker.service.TimeService;
import com.droege.fitnesstracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time")
@CrossOrigin
public class TimeController {

    @Autowired
    TimeService timeService;

    @PostMapping("/add")
    public String add(@RequestBody Time time) {
        timeService.saveTime(time);
        return "New user is added";
    }

    @GetMapping("/getAll")
    public List<Time> getAll() {
        return timeService.getAllTime();

    }
}

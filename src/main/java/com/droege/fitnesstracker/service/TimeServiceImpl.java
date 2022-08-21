package com.droege.fitnesstracker.service;

import com.droege.fitnesstracker.model.Time;
import com.droege.fitnesstracker.model.User;
import com.droege.fitnesstracker.repository.TimeRepository;
import com.droege.fitnesstracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeRepository timeRepository;

    @Override
    public Time saveTime(Time time) {
        return timeRepository.save(time);
    }

    @Override
    public List<Time> getAllTime() {
        return timeRepository.findAll();
    }
}

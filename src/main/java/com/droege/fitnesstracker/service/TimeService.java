package com.droege.fitnesstracker.service;

import com.droege.fitnesstracker.model.Time;
import com.droege.fitnesstracker.model.User;

import java.util.List;

public interface TimeService {

    public Time saveTime(Time time);

    public List<Time> getAllTime();
}

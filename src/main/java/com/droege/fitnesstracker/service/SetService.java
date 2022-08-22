package com.droege.fitnesstracker.service;

import com.droege.fitnesstracker.model.Set;

import java.util.List;

public interface SetService {

    public Set saveSet(Set set);

    public List<Set> getAllSets();
}

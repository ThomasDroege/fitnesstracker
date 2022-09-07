package com.droege.fitnesstracker.service;

import com.droege.fitnesstracker.model.Set;
import com.droege.fitnesstracker.repository.SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetService {

    @Autowired
    private SetRepository setRepository;

    public Set saveSet(Set set) {
        return setRepository.save(set);
    }

    public List<Set> getAllSets() {
        return setRepository.findAll();
    }
}

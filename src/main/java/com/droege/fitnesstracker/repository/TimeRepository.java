package com.droege.fitnesstracker.repository;

import com.droege.fitnesstracker.model.Time;
import com.droege.fitnesstracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {
}

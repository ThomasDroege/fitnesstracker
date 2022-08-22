package com.droege.fitnesstracker.repository;

import com.droege.fitnesstracker.model.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetRepository extends JpaRepository<Set, Integer> {
}

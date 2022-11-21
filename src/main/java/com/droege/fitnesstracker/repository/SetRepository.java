package com.droege.fitnesstracker.repository;

import com.droege.fitnesstracker.model.Set;
import com.droege.fitnesstracker.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetRepository extends JpaRepository<Set, Integer> {

    @Query(nativeQuery = true, value="SELECT s.set_id, s.workout_id, s.exercise_id, s.repititions, s.weight, w.user_id, w.time_started, w.time_ended " +
            "FROM daten.set s " +
            "INNER JOIN daten.workout w  on s.workout_id = w.workout_id ")
    List<Set> findAllWorkoutsWithSets();
}

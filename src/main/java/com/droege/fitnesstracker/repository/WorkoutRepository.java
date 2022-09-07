package com.droege.fitnesstracker.repository;

import com.droege.fitnesstracker.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

    @Query(nativeQuery=true, value="SELECT  w.user_id , w.workout_id, w.time_started ,w.time_ended  " +
            "FROM daten.workout w join daten.user u on u.user_id =w.user_id  where u.user_id = :userId")
    List<Workout> findByUserId(Integer userId);

}

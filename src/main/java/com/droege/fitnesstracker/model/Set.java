package com.droege.fitnesstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long set_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "workout_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Workout workout;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "exercise_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Exercise exercise;

    private Long repititions;

    private Float weight;



    private LocalDateTime time_started;


    private LocalDateTime time_ended;

    public Set() {
    }

    public Long getSet_id() {
        return set_id;
    }

    public void setSet_id(Long set_id) {
        this.set_id = set_id;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Long getRepititions() {
        return repititions;
    }

    public void setRepititions(Long repititions) {
        this.repititions = repititions;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public LocalDateTime getTime_started() {
        return time_started;
    }

    public void setTime_started(LocalDateTime time_started) {
        this.time_started = time_started;
    }

    public LocalDateTime getTime_ended() {
        return time_ended;
    }

    public void setTime_ended(LocalDateTime time_ended) {
        this.time_ended = time_ended;
    }
}

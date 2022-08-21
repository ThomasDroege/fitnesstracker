package com.droege.fitnesstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workout_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;



    private LocalDateTime time_started;


    private LocalDateTime time_ended;

    public Workout() {
    }

    public Long getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(Long workout_id) {
        this.workout_id = workout_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

package com.droege.fitnesstracker.reponse;

import java.util.List;

public class WorkoutResponse {

    Integer workoutId;
    String timeStarted;
    String timeEnded;
    Integer userId;
    List<SetResponse> sets;

    public Integer getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
    }

    public String getTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(String timeStarted) {
        this.timeStarted = timeStarted;
    }

    public String getTimeEnded() {
        return timeEnded;
    }

    public void setTimeEnded(String timeEnded) {
        this.timeEnded = timeEnded;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<SetResponse> getSets() {
        return sets;
    }

    public void setSets(List<SetResponse> sets) {
        this.sets = sets;
    }
}



package com.droege.fitnesstracker.service;

import com.droege.fitnesstracker.model.Set;
import com.droege.fitnesstracker.model.Workout;
import com.droege.fitnesstracker.reponse.SetResponse;
import com.droege.fitnesstracker.reponse.WorkoutResponse;
import com.droege.fitnesstracker.reponse.WorkoutResponses;
import com.droege.fitnesstracker.repository.SetRepository;
import com.droege.fitnesstracker.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    WorkoutRepository workoutRepository;

    @Autowired
    SetRepository setRepository;

    public  Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public List<Workout> getByUserId(Integer userId) {
        return workoutRepository.findByUserId(userId);
    }

    public WorkoutResponses getAllWorkoutsWithSets() {
        List<Set>  sets =  setRepository.findAllWorkoutsWithSets();

        WorkoutResponses workoutResponses = new WorkoutResponses();
        List<WorkoutResponse> workoutResponseList = new ArrayList<WorkoutResponse>();
        List<SetResponse> setResponses = new ArrayList<SetResponse>();
        WorkoutResponse workoutResponse = new WorkoutResponse();

        Integer workoutId = sets.get(0).getWorkout().getId();
        workoutResponse.setWorkoutId(sets.get(0).getWorkout().getId());
        workoutResponse.setTimeStarted(sets.get(0).getWorkout().getTimeStarted().toString());
        workoutResponse.setTimeEnded(sets.get(0).getWorkout().getTimeEnded().toString());
        workoutResponse.setUserId(sets.get(0).getWorkout().getUser().getId());

        for (Set set: sets) {
                if(set.getWorkout().getId() != workoutId){
                    workoutResponse.setSets(setResponses);
                    workoutResponseList.add(workoutResponse);
                    workoutResponse = new WorkoutResponse();
                    setResponses = new ArrayList<SetResponse>();
                    workoutResponse.setWorkoutId(set.getWorkout().getId());
                    workoutResponse.setTimeStarted(set.getWorkout().getTimeStarted().toString());
                    workoutResponse.setTimeEnded(set.getWorkout().getTimeEnded().toString());
                    workoutResponse.setUserId(set.getWorkout().getUser().getId());
                    workoutId = set.getWorkout().getId();
                }

                SetResponse setResponse = new SetResponse();
                setResponse.setSetId(set.getSetId());
                setResponse.setExerciseId(set.getExercise().getExerciseId());
                setResponse.setRepititions(set.getRepititions());
                setResponse.setWeight(set.getWeight());
                setResponse.setTimeStarted(set.getTime_started().toString());
                setResponse.setTimeEnded(set.getTime_ended().toString());
                setResponses.add(setResponse);
        }
        // Fügt das letzte Workout hinzu. Zeile nötig, da es keinen Wechsel der WorkoutId mehr gibt.
        workoutResponse.setSets(setResponses);
        workoutResponseList.add(workoutResponse);

        workoutResponses.setWorkoutResponses(workoutResponseList);
        return workoutResponses;
    }

}

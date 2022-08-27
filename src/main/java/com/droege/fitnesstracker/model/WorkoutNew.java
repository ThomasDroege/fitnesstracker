package com.droege.fitnesstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

//Comment
@Entity
@Data //Getter and Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "workout", schema = "daten")
public class WorkoutNew {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    private Long workoutId;


    @Column(name = "time_started")
    private LocalDateTime timeStarted;

    @Column(name = "time_ended")
    private LocalDateTime timeEnded;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

}

package com.droege.fitnesstracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data //Getter and Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "workout", schema = "daten")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    private Integer id;


    @Column(name = "time_started")
    private LocalDateTime timeStarted;

    @Column(name = "time_ended")
    private LocalDateTime timeEnded;


    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id" )
    //@JoinColumn(name  = "user_id")
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "workout_id")
    private User user;


}

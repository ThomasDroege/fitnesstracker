package com.droege.fitnesstracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

//Post
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user", schema = "daten")
public class UserNew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(targetEntity = Workout.class, cascade = CascadeType.ALL)
    // name = name in workouts table, referencedColumnName = name in user table
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<Workout> workouts;
}

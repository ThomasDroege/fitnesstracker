package com.droege.fitnesstracker.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long time_id;


    private String name;

    public Time() {
    }


    public Long getTime_id() {
        return time_id;
    }

    public void setTime_id(Long time_id) {
        this.time_id = time_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

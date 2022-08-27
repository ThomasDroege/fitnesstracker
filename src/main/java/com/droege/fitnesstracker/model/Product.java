package com.droege.fitnesstracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name ="product", schema = "daten")
public class Product {

    @Id
    //Manually!
    private int pid;
    private String productname;
    private int qty;
    private int price;


}

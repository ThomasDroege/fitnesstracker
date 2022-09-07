package com.droege.fitnesstracker.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "contact_master", schema = "daten")
public class ContactsMasterEntity {

    @Id
    @Column(name = "contact_id")
    private Integer contactId;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_number")
    private Long contactNumber;

}

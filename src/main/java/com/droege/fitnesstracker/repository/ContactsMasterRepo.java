package com.droege.fitnesstracker.repository;

import com.droege.fitnesstracker.model.ContactsMasterEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactsMasterRepo extends CrudRepository<ContactsMasterEntity, Integer> {

    //select * from contacts_master where contact_name='name';
    public ContactsMasterEntity findByContactName(String name);

    //select * from contacts_master where contact_name='name' and contact_number='number'
    public ContactsMasterEntity findByContactNameAndContactNumber(String name, Long number);

    public List<ContactsMasterEntity> findAllByContactName(String name);

}

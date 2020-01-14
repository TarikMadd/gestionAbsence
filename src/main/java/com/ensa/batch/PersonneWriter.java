package com.ensa.batch;


import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.models.Personne;
import com.ensa.repositories.PersonneRepository;

@Component
public class PersonneWriter implements ItemWriter<Personne> {

    @Autowired
    private PersonneRepository employeeRepository;

    @Override
    public void write(List<? extends Personne> employees) throws Exception {
        employeeRepository.saveAll(employees);
    }
}

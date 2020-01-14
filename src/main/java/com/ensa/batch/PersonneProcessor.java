package com.ensa.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.ensa.models.Personne;

@Component
public class PersonneProcessor implements ItemProcessor<Personne, Personne> {


    @Override
    public Personne process(Personne employee) throws Exception {
        return employee;
    }
}

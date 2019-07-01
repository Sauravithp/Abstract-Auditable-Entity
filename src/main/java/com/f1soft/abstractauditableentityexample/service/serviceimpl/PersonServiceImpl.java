package com.f1soft.abstractauditableentityexample.service.serviceimpl;

import com.f1soft.abstractauditableentityexample.entity.Person;
import com.f1soft.abstractauditableentityexample.repository.PersonRepository;
import com.f1soft.abstractauditableentityexample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public Person create(Person person) {
        return  personRepository.save(person);
    }
}

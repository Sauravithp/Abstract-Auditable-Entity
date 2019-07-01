package com.f1soft.abstractauditableentityexample.repository;

import com.f1soft.abstractauditableentityexample.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Long> {
}

package com.example.microservice.exemplo3.repositories;

import com.example.microservice.exemplo3.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}

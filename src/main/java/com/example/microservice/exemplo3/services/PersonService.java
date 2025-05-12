package com.example.microservice.exemplo3.services;

import com.example.microservice.exemplo3.exceptions.ResourceNotFoundException;
import com.example.microservice.exemplo3.models.Person;
import com.example.microservice.exemplo3.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
//    private final AtomicLong counter = new AtomicLong(); //Multithread
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository repository;

    public Person create(Person person){
        logger.info("Creating a person");

        //return person;
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating a person");

        //return person;

        Person personUpdated = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        personUpdated.setAddress(person.getAddress());
        personUpdated.setFirstName(person.getFirstName());
        personUpdated.setLastName(person.getLastName());
        personUpdated.setGender(person.getGender());

        return repository.save(person);
    }

    //public void delete(String id){
    public void delete(Long id){
        logger.info("Deleating a person");

        Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        repository.delete(person);
    }

    //public Person findById(String id){
    public Person findById(Long id){
        logger.info("Finding a person!");

//        Person person = new Person();
//        person.setId(counter.incrementAndGet());
//        person.setAddress("Rua 1");
//        person.setFirstName("Raphael");
//        person.setLastName("Gava");
//        person.setGender("Masculino");
//        return person;
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
    }

    public List<Person> findAll(){
        logger.info("Finding all people!");

//        List<Person> persons = new ArrayList<>();
//        for (int i = 0; i < 8; i++){
//            Person person = mockPerson(i);
//            persons.add(person);
//        }
//        return persons;
        return repository.findAll();
    }

//    private Person mockPerson(int i){
//        Person person = new Person();
//        person.setId(counter.incrementAndGet());
//        person.setAddress("Rua " + i);
//        person.setFirstName("Raphael " + i);
//        person.setLastName("Gava " + i);
//        person.setGender("Masculino");
//        return person;
//    }

}

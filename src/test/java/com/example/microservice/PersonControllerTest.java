package com.example.microservice;

import com.example.microservice.exemplo3.controllers.PersonController;
import com.example.microservice.exemplo3.model.Person;
import com.example.microservice.exemplo3.services.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PersonControllerTest {

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonService personService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() throws Exception {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAddress("123 Main St");
        person.setGender("Male");

        when(personService.create(any(Person.class))).thenReturn(person);

        Person createdPerson = personController.create(person);

        assertNotNull(createdPerson);
        assertEquals("John", createdPerson.getFirstName());
        verify(personService, times(1)).create(any(Person.class));
    }

    @Test
    public void testUpdate() throws Exception {
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("Jane");
        person.setLastName("Doe");
        person.setAddress("456 Elm St");
        person.setGender("Female");

        when(personService.update(any(Person.class))).thenReturn(person);

        Person updatedPerson = personController.update(person);

        assertNotNull(updatedPerson);
        assertEquals("Jane", updatedPerson.getFirstName());
        verify(personService, times(1)).update(any(Person.class));
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(personService).delete(anyLong());

        ResponseEntity<?> response = personController.delete(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(personService, times(1)).delete(anyLong());
    }

    @Test
    public void testFindById() throws Exception {
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("John");
        person.setLastName("Doe");

        when(personService.findById(anyLong())).thenReturn(person);

        Person foundPerson = personController.findById(1L);

        assertNotNull(foundPerson);
        assertEquals("John", foundPerson.getFirstName());
        verify(personService, times(1)).findById(anyLong());
    }

    @Test
    public void testFindAll() throws Exception {
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Doe");

        Person person2 = new Person();
        person2.setFirstName("Jane");
        person2.setLastName("Doe");

        List<Person> personList = Arrays.asList(person1, person2);

        when(personService.findAll()).thenReturn(personList);

        List<Person> foundPersons = personController.findAll();

        assertNotNull(foundPersons);
        assertEquals(2, foundPersons.size());
        verify(personService, times(1)).findAll();
    }
}

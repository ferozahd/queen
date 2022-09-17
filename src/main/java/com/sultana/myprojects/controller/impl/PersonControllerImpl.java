package com.sultana.myprojects.controller.impl;


import com.sultana.myprojects.controller.PersonController;
import com.sultana.myprojects.entity.Person;
import com.sultana.myprojects.moduls.person.PersonGetResponse;
import com.sultana.myprojects.moduls.person.PersonPatchResources;
import com.sultana.myprojects.moduls.person.PersonPostResources;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonControllerImpl implements PersonController {
    private final MongoTemplate mongoTemplate;


    @Override
    public ResponseEntity<PersonGetResponse> create(
//    Application layer
            PersonPostResources post
    ) {

//        Data layer
        Person person = new Person();
        person.setName(post.getName());
        person.setSchool(post.getSchool());
        person.setAge(post.getAge());
        person.setAddress(post.getAddress());
        mongoTemplate.save(person);
//Presentation payer
        PersonGetResponse response = new PersonGetResponse();
        response.setId(person.getId().toHexString());
        response.setName(person.getName());
        response.setSchool(person.getSchool());
        response.setAddress(person.getAddress());
        response.setAge(person.getAge());


        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<PersonGetResponse>> getAll() {
        List<Person> asd = mongoTemplate.findAll(Person.class);

        List<PersonGetResponse> responses = new ArrayList<>();

        asd.forEach(person -> {
            PersonGetResponse response = new PersonGetResponse();
            response.setId(person.getId().toHexString());
            response.setName(person.getName());
            response.setSchool(person.getSchool());
            response.setAddress(person.getAddress());
            response.setAge(person.getAge());
            responses.add(response);
        });
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<Person> update(PersonPatchResources patch) {

        
        return null;
    }

    @Override
    public ResponseEntity<Person> delete(String id) {
        return null;
    }


}

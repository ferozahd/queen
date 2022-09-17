package com.sultana.myprojects.controller;


import com.sultana.myprojects.entity.Person;
import com.sultana.myprojects.moduls.person.PersonGetResponse;
import com.sultana.myprojects.moduls.person.PersonPatchResources;
import com.sultana.myprojects.moduls.person.PersonPostResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("person")
public interface PersonController {
    @PostMapping("/")
    ResponseEntity<PersonGetResponse> create(@RequestBody PersonPostResources post);

    @GetMapping("getAll")
    ResponseEntity<List<PersonGetResponse>> getAll();

    @PatchMapping("update")
    ResponseEntity<Person> update(@RequestBody PersonPatchResources patch);

    @DeleteMapping("delete/{id}")
    ResponseEntity<Person> delete(@PathVariable String id);
}































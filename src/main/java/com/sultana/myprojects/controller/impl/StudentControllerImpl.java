package com.sultana.myprojects.controller.impl;

import com.sultana.myprojects.controller.StudentController;
import com.sultana.myprojects.entity.Student;
import com.sultana.myprojects.moduls.student.StudentGetResources;
import com.sultana.myprojects.moduls.student.StudentPatchResources;
import com.sultana.myprojects.moduls.student.StudentPostResources;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class StudentControllerImpl implements StudentController {
    private final MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity<StudentGetResources> create(StudentPostResources post) {
        Student student = new Student();
        student.setFirstName(post.getFirstName());
        student.setLastName(post.getLastName());
        student.setAge(post.getAge());
        student.setMotherName(post.getMotherName());
        student.setFatherName(post.getFatherName());
        mongoTemplate.save(student);

        StudentGetResources response = new StudentGetResources();
        response.setId(student.getId().toHexString());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setFatherName(student.getFatherName());
        response.setMotherName(student.getMotherName());
        response.setAge(student.getAge());
        return ResponseEntity.ok(response);

    }


    @Override
    public ResponseEntity<List<StudentGetResources>> getAll() {
        List<Student> acv = mongoTemplate.findAll(Student.class);

        List<StudentGetResources> responses = new ArrayList<>();

        acv.forEach(student -> {
            StudentGetResources response = new StudentGetResources();

            response.setId(student.getId().toHexString());
            response.setFirstName(student.getFirstName());
            response.setLastName(student.getLastName());
            response.setFatherName(student.getFatherName());
            response.setMotherName(student.getMotherName());
            response.setAge(student.getAge());
            responses.add(response);
        });
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<Student> update(StudentPatchResources patch) {
        return null;
    }

    @Override
    public ResponseEntity<Student> delete(String id) {
        return null;
    }
}

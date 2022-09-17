package com.sultana.myprojects.controller;

import com.sultana.myprojects.entity.Student;
import com.sultana.myprojects.moduls.student.StudentGetResources;
import com.sultana.myprojects.moduls.student.StudentPatchResources;
import com.sultana.myprojects.moduls.student.StudentPostResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student")
public interface StudentController {
    @PostMapping("/create")
    ResponseEntity<StudentGetResources> create(@RequestBody StudentPostResources post);

    @GetMapping("getAll")
    ResponseEntity<List<StudentGetResources>> getAll();

    @PatchMapping("update")
    ResponseEntity<Student> update(@RequestBody StudentPatchResources patch);

    @DeleteMapping("delete/{id}")
    ResponseEntity<Student> delete(@PathVariable String id);
}

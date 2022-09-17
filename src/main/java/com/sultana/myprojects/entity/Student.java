package com.sultana.myprojects.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "student")
public class Student {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private int age;

}

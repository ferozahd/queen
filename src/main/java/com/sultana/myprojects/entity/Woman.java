package com.sultana.myprojects.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "woman")
public class Woman {
    @Id
    private ObjectId id;
    private String name;
    private String childName;
    private String zila;
    private int age;
}

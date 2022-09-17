package com.sultana.myprojects.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "man")
public class Man {
    @Id
    private ObjectId id;
    private String name;
    private String officeName;
    private int homeNumber;
    private int age;

}

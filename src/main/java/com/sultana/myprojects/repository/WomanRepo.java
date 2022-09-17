package com.sultana.myprojects.repository;

import com.sultana.myprojects.entity.Woman;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WomanRepo extends MongoRepository<Woman, ObjectId> {
}

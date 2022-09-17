package com.sultana.myprojects.controller.impl;

import com.sultana.myprojects.controller.ManController;
import com.sultana.myprojects.entity.Man;
import com.sultana.myprojects.moduls.man.ManGetResources;
import com.sultana.myprojects.moduls.man.ManPatchResources;
import com.sultana.myprojects.moduls.man.ManPostResources;
import com.sultana.myprojects.repository.ManRepo;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class ManControllerImpl implements ManController {
    private final MongoTemplate mongoTemplate;
    private final ManRepo manRepo;

    @Override
    public ResponseEntity<ManGetResources> create(ManPostResources post) {
        Man man = new Man();
        man.setName(post.getName());
        man.setOfficeName(post.getOfficeName());
        man.setHomeNumber(post.getHomeNumber());
        man.setAge(post.getAge());
        manRepo.save(man);
        ManGetResources resources = new ManGetResources();
        resources.setId(man.getId().toHexString());
        resources.setName(man.getName());
        resources.setAge(man.getAge());
        resources.setHomeNumber(man.getHomeNumber());

        return ResponseEntity.ok(resources);
    }

    @Override
    public ResponseEntity<List<ManGetResources>> getAll() {
        List<Man> sultana = manRepo.findAll();

        List<ManGetResources> responses = new ArrayList<>();

        sultana.forEach(man -> {
            ManGetResources response = new ManGetResources();
            response.setId(man.getId().toHexString());
            response.setName(man.getName());
            response.setOfficeName(man.getOfficeName());
            response.setHomeNumber(man.getHomeNumber());
            response.setAge(man.getAge());
            responses.add(response);
        });
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<ManGetResources> update(ManPatchResources patch, String id) {
        Man man = manRepo.findById(new ObjectId(id)).orElseThrow(() -> new RuntimeException());
        man.setAge(patch.getAge());
        man.setName(patch.getName());
        manRepo.save(man);
        ManGetResources resources = new ManGetResources();
        resources.setId(man.getId().toHexString());
        resources.setName(man.getName());
        resources.setAge(man.getAge());


        return ResponseEntity.ok(resources);
    }

    @Override
    public ResponseEntity<ManGetResources> delete(String id) {
        manRepo.deleteById(new ObjectId(id));
        return null;
    }
}

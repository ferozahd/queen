package com.sultana.myprojects.controller.impl;

import com.sultana.myprojects.controller.WomanController;
import com.sultana.myprojects.moduls.woman.WomanGetResources;
import com.sultana.myprojects.moduls.woman.WomanPatchResources;
import com.sultana.myprojects.moduls.woman.WomanPostResources;
import com.sultana.myprojects.repository.WomanRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WomanControllerImpl implements WomanController {
    private final WomanRepo womanRepo;

    @Override
    public ResponseEntity<WomanGetResources> create(WomanPostResources post) {

        return null;
    }

    @Override
    public ResponseEntity<List<WomanGetResources>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<WomanGetResources> update(WomanPatchResources patch) {
        return null;
    }

    @Override
    public ResponseEntity<WomanGetResources> delete(String id) {
        return null;
    }
}

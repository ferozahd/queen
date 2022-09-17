package com.sultana.myprojects.controller;


import com.sultana.myprojects.moduls.man.ManGetResources;
import com.sultana.myprojects.moduls.man.ManPatchResources;
import com.sultana.myprojects.moduls.man.ManPostResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/man")
public interface ManController {
    @PostMapping("/create")
    ResponseEntity<ManGetResources> create(@RequestBody ManPostResources post);

    @GetMapping("getAll")
    ResponseEntity<List<ManGetResources>> getAll();

    @PatchMapping("update/{id}")
    ResponseEntity<ManGetResources> update(@RequestBody ManPatchResources patch, @PathVariable String id);

    @DeleteMapping("delete/{id}")
    ResponseEntity<ManGetResources> delete(@PathVariable String id);
}

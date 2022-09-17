package com.sultana.myprojects.controller;


import com.sultana.myprojects.moduls.woman.WomanGetResources;
import com.sultana.myprojects.moduls.woman.WomanPatchResources;
import com.sultana.myprojects.moduls.woman.WomanPostResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/woman")
public interface WomanController {
    @PostMapping("/create")
    ResponseEntity<WomanGetResources> create(@RequestBody WomanPostResources post);

    @GetMapping("getAll")
    ResponseEntity<List<WomanGetResources>> getAll();

    @PatchMapping("update")
    ResponseEntity<WomanGetResources> update(@RequestBody WomanPatchResources patch);

    @DeleteMapping("delete/{id}")
    ResponseEntity<WomanGetResources> delete(@PathVariable String id);
}

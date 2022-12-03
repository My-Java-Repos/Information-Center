package com.org.fantasyinfocenterdemo.controller;

import com.org.fantasyinfocenterdemo.model.Universe;
import com.org.fantasyinfocenterdemo.model.dto.UniverseDto;
import com.org.fantasyinfocenterdemo.repository.UniversesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/universes")
public class UniversesController {

    @Autowired
    private UniversesRepository universesRepository;

    @GetMapping("")
    public ResponseEntity<?> getAllUniverses() {
        // Payload Validation
        // Payload Transformation
        // Service Executions
        List<Universe> universes = universesRepository.findAll();
        // Response Parsing
        return new ResponseEntity<>(universes, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addNewUniverse(@RequestBody UniverseDto universeDto) {
        // Payload Validation
        // Payload Transformation
        // Service Executions
        Universe universe = new Universe(null, universeDto.getName(), null, null);
        universesRepository.save(universe);
        // Response Parsing
        return new ResponseEntity<>("Universe created.", HttpStatus.CREATED);
    }
}

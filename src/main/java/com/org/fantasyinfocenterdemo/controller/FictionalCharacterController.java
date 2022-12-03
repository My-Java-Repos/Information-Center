package com.org.fantasyinfocenterdemo.controller;

import com.org.fantasyinfocenterdemo.model.FictionalCharacter;
import com.org.fantasyinfocenterdemo.model.dto.FictionalCharacterDto;
import com.org.fantasyinfocenterdemo.model.dto.FictionalCharacterPutDto;
import com.org.fantasyinfocenterdemo.service.FictionalCharacterService;
import com.org.fantasyinfocenterdemo.validation.FictionalCharacterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/fictional-characters")
public class FictionalCharacterController {

    @Autowired
    private FictionalCharacterService fictionalCharacterService;

    @GetMapping("")
    public ResponseEntity<?> getAllCharacters() {
        // Payload Validation
        // Payload Transformation
        // Service Executions
        List<FictionalCharacter> fictionalCharacters = fictionalCharacterService.getAllFictionalCharacters();
        // Response Parsing
        return new ResponseEntity<>(fictionalCharacters, HttpStatus.OK);
    }

    @GetMapping("/by-universe/{id}")
    public ResponseEntity<?> getAllCharactersByUniverseId(@PathVariable Integer id) {
        // Payload Validation
        // Payload Transformation
        // Service Executions
        List<FictionalCharacter> fictionalCharacters =
                fictionalCharacterService.getAllFictionalCharactersByUniverseId(id);
        // Response Parsing
        return new ResponseEntity<>(fictionalCharacters, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addNewCharacter(@RequestBody FictionalCharacterDto fictionalCharacterDto)
            throws Exception {
        // Payload Validation
        FictionalCharacterValidator.validateFictionalCharacterDto(fictionalCharacterDto);
        // Payload Transformation
        // Service Executions
        fictionalCharacterService.addFictionalCharacter(fictionalCharacterDto);
        // Response Parsing
        return new ResponseEntity<>("Fictional Character created.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFictionalCharacter(@RequestBody FictionalCharacterPutDto fictionalCharacterPutDto)
            throws Exception {
        // Payload Validation
        FictionalCharacterValidator.validateFictionalCharacterDto(fictionalCharacterPutDto);
        // Payload Transformation
        // Service Executions
        fictionalCharacterService.updateFictionalCharacter(fictionalCharacterPutDto.getId(), fictionalCharacterPutDto);
        // Response Parsing
        return new ResponseEntity<>("Fictional Character updated.", HttpStatus.NO_CONTENT);
    }
}

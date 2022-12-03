package com.org.fantasyinfocenterdemo.controller;

import com.org.fantasyinfocenterdemo.model.MediaType;
import com.org.fantasyinfocenterdemo.model.dto.MediaTypeDto;
import com.org.fantasyinfocenterdemo.repository.MediaTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/media-types")
public class MediaTypesController {

    @Autowired
    private MediaTypesRepository mediaTypesRepository;

    @GetMapping("")
    public ResponseEntity<?> getAllMediaTypes() {
        // Payload Validation
        // Payload Transformation
        // Service Executions
        List<MediaType> mediaTypes = mediaTypesRepository.findAll();
        return new ResponseEntity<>(mediaTypes, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addNewMediaType(@RequestBody MediaTypeDto mediaTypeDto) {
        // Payload Validation
        // Payload Transformation
        // Service Executions
        MediaType mediaType = new MediaType(null, mediaTypeDto.getName(), null);
        mediaTypesRepository.save(mediaType);
        // Response Parsing
        return new ResponseEntity<>("Media Type created.", HttpStatus.CREATED);
    }
}

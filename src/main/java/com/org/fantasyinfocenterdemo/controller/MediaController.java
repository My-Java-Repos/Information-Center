package com.org.fantasyinfocenterdemo.controller;

import com.org.fantasyinfocenterdemo.model.Medium;
import com.org.fantasyinfocenterdemo.model.dto.MediumDto;
import com.org.fantasyinfocenterdemo.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @GetMapping("")
    public ResponseEntity<?> getAllMedia() {
        // Payload Validation
        // Payload Transformation
        // Service Executions
        List<Medium> media = mediaService.getAllMedia();
        return new ResponseEntity<>(media, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addNewMedium(@RequestBody MediumDto mediumDto) throws Exception {
        // Payload Validation
        // Payload Transformation
        // Service Executions
        mediaService.addMedium(mediumDto);
        // Response Parsing
        return new ResponseEntity<>("Medium created.", HttpStatus.CREATED);
    }
}

package com.org.fantasyinfocenterdemo.service;

import com.org.fantasyinfocenterdemo.model.FictionalCharacter;
import com.org.fantasyinfocenterdemo.model.MediaType;
import com.org.fantasyinfocenterdemo.model.Medium;
import com.org.fantasyinfocenterdemo.model.Universe;
import com.org.fantasyinfocenterdemo.model.dto.MediumDto;
import com.org.fantasyinfocenterdemo.repository.FictionalCharactersRepository;
import com.org.fantasyinfocenterdemo.repository.MediaRepository;
import com.org.fantasyinfocenterdemo.repository.MediaTypesRepository;
import com.org.fantasyinfocenterdemo.repository.UniversesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MediaService {

    @Autowired
    private FictionalCharactersRepository fictionalCharactersRepository;

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private MediaTypesRepository mediaTypesRepository;

    @Autowired
    private UniversesRepository universesRepository;

    public List<Medium> getAllMedia() {
        return mediaRepository.findAll();
    }

    public void addMedium(MediumDto mediumDto) throws Exception {
        // Finds the Universe by Id.
        // If not found, throws Exception
        Universe universe = universesRepository.findById(mediumDto.getUniverseId()).orElse(null);
        if (universe == null) {
            throw new Exception("Universe not found");
        }

        // Finds the Media Type by name.
        // If not found, throws Exception.
        MediaType mediaType = mediaTypesRepository.findByName(mediumDto.getMediaType());
        if (mediaType == null) {
            throw new Exception("Media Type not found");
        }

        // Finds all Fictional Characters.
        // If a Fictional Character is not found by name, it is simply not inserted.
        List<FictionalCharacter> fictionalCharacters = new ArrayList<>();
        for (String fictionalCharacterName: mediumDto.getFictionalCharacters()) {
            FictionalCharacter fictionalCharacter = fictionalCharactersRepository.findByName(fictionalCharacterName);
            if (fictionalCharacter == null) {
                continue;
            }

            fictionalCharacters.add(fictionalCharacter);
        }

        Medium medium = new Medium(null,
                mediumDto.getTitle(),
                mediumDto.getDescription(),
                universe,
                mediaType,
                fictionalCharacters);
        mediaRepository.save(medium);
    }
}

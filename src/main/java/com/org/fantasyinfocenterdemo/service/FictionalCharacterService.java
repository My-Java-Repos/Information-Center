package com.org.fantasyinfocenterdemo.service;

import com.org.fantasyinfocenterdemo.exception.FantasyInfoCenterEntityNotFound;
import com.org.fantasyinfocenterdemo.mapper.FictionalCharacterMapper;
import com.org.fantasyinfocenterdemo.model.FictionalCharacter;
import com.org.fantasyinfocenterdemo.model.Universe;
import com.org.fantasyinfocenterdemo.model.dto.FictionalCharacterDto;
import com.org.fantasyinfocenterdemo.model.dto.FictionalCharacterPutDto;
import com.org.fantasyinfocenterdemo.repository.FictionalCharactersRepository;
import com.org.fantasyinfocenterdemo.repository.UniversesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FictionalCharacterService {

    @Autowired
    private FictionalCharactersRepository fictionalCharactersRepository;

    @Autowired
    private UniversesRepository universesRepository;

    public List<FictionalCharacter> getAllFictionalCharacters() {
        return fictionalCharactersRepository.findAll();
    }

    public List<FictionalCharacter> getAllFictionalCharactersByUniverseId(Integer universeId) {
        List<FictionalCharacter> fictionalCharacters = new ArrayList<>();
        fictionalCharactersRepository.findAllByUniverseId(universeId).forEach(fictionalCharacters::add);
        return fictionalCharacters;
    }

    public void addFictionalCharacter(FictionalCharacterDto fictionalCharacterDto)
            throws Exception {
        // Finds the Universe by Id.
        // If not found, throw Exception
        Universe universe = universesRepository.findById(fictionalCharacterDto.getUniverseId()).orElse(null);

        if (universe == null) {
            throw new Exception("Universe not found");
        }

        FictionalCharacter fictionalCharacter = new FictionalCharacter(null,
                fictionalCharacterDto.getName(),
                fictionalCharacterDto.getDateOfBirth(),
                universe,
                null);
        fictionalCharactersRepository.save(fictionalCharacter);
    }

    public void updateFictionalCharacter(Integer id, FictionalCharacterPutDto fictionalCharacterPutDto)
            throws Exception {
        // Find existing character by id.
        // If character does not exist, we should throw an Exception.
        FictionalCharacter existingFictionalCharacter = fictionalCharactersRepository
                .findById(id)
                .orElse(null);

        if (existingFictionalCharacter == null) {
            throw new FantasyInfoCenterEntityNotFound("Fictional Character", id);
        }

        // Find the Universe by Id.
        // If not found, throw Exception
        Universe universe = universesRepository.findById(fictionalCharacterPutDto.getUniverseId()).orElse(null);

        if (universe == null) {
            throw new Exception("Universe not found");
        }

        existingFictionalCharacter = FictionalCharacterMapper.from(fictionalCharacterPutDto, universe);
        fictionalCharactersRepository.save(existingFictionalCharacter);
    }
}

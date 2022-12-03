package com.org.fantasyinfocenterdemo.mapper;

import com.org.fantasyinfocenterdemo.model.FictionalCharacter;
import com.org.fantasyinfocenterdemo.model.Universe;
import com.org.fantasyinfocenterdemo.model.dto.FictionalCharacterDto;
import com.org.fantasyinfocenterdemo.model.dto.FictionalCharacterPutDto;

public final class FictionalCharacterMapper {

    private FictionalCharacterMapper() {
        throw new IllegalStateException("Mappers are not meant to be instantiated.");
    }

    public static FictionalCharacter from(FictionalCharacterDto fictionalCharacterDto,
                                   Universe universe) {
        FictionalCharacter fictionalCharacter = new FictionalCharacter();
        fictionalCharacter.setId(fictionalCharacterDto.getId());
        fictionalCharacter.setName(fictionalCharacterDto.getName());
        fictionalCharacter.setDateOfBirth(fictionalCharacterDto.getDateOfBirth());
        fictionalCharacter.setUniverse(universe);

        return new FictionalCharacter();
    }

    public static FictionalCharacter from(FictionalCharacterPutDto fictionalCharacterPutDto,
                                   Universe universe) {

        FictionalCharacter fictionalCharacter = new FictionalCharacter();
        fictionalCharacter.setId(fictionalCharacterPutDto.getId());
        fictionalCharacter.setName(fictionalCharacterPutDto.getName());
        fictionalCharacter.setDateOfBirth(fictionalCharacterPutDto.getDateOfBirth());
        fictionalCharacter.setUniverse(universe);

        return fictionalCharacter;
    }
}

package com.org.fantasyinfocenterdemo.validation;

import com.org.fantasyinfocenterdemo.model.dto.FictionalCharacterDto;
import com.org.fantasyinfocenterdemo.model.dto.FictionalCharacterPutDto;

public final class FictionalCharacterValidator {

    private FictionalCharacterValidator() {
        throw new IllegalStateException("Validators are not meant to be instantiated.");
    }

    public static void validateFictionalCharacterDto(FictionalCharacterDto fictionalCharacterDto) {
        if (fictionalCharacterDto.getName() == null || fictionalCharacterDto.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name should not be empty.");
        }
    }

    public static void validateFictionalCharacterDto(FictionalCharacterPutDto fictionalCharacterPutDto) {
        if (fictionalCharacterPutDto.getName() == null || fictionalCharacterPutDto.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name should not be empty.");
        }
    }
}

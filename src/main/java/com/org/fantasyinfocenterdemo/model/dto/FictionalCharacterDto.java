package com.org.fantasyinfocenterdemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FictionalCharacterDto {

    private Integer id;
    private String name;
    private LocalDate dateOfBirth;
    private Integer universeId;
}

package com.org.fantasyinfocenterdemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediumDto {

    private Integer id;
    private String title;
    private String description;
    private Integer universeId;
    private String mediaType;
    private List<String> fictionalCharacters;
}

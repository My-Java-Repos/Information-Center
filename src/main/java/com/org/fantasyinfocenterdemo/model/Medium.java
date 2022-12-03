package com.org.fantasyinfocenterdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medium {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    @Column(length = 5000)
    private String description;

    @ManyToOne
    private Universe universe;

    @ManyToOne
    private MediaType mediaType;

    @ManyToMany
    private List<FictionalCharacter> fictionalCharacters;
}

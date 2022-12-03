package com.org.fantasyinfocenterdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FictionalCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private LocalDate dateOfBirth;

    @ManyToOne
    private Universe universe;

    @ManyToMany
    private List<Medium> media;
}

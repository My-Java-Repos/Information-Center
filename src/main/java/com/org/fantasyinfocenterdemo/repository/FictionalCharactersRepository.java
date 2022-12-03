package com.org.fantasyinfocenterdemo.repository;

import com.org.fantasyinfocenterdemo.model.FictionalCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FictionalCharactersRepository extends JpaRepository<FictionalCharacter, Integer> {
    FictionalCharacter findByName(String name);
    List<FictionalCharacter> findAllByUniverseId(Integer universeId);
}

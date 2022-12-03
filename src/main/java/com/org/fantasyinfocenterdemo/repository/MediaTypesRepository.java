package com.org.fantasyinfocenterdemo.repository;

import com.org.fantasyinfocenterdemo.model.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaTypesRepository extends JpaRepository<MediaType, Integer> {
    MediaType findByName(String name);
}

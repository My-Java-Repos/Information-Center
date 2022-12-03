package com.org.fantasyinfocenterdemo.repository;

import com.org.fantasyinfocenterdemo.model.Universe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversesRepository extends JpaRepository<Universe, Integer> {
}

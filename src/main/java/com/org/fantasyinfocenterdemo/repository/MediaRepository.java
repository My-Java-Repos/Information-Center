package com.org.fantasyinfocenterdemo.repository;

import com.org.fantasyinfocenterdemo.model.Medium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Medium, Integer> {
}

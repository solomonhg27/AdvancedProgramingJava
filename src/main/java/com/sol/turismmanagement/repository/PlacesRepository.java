package com.sol.turismmanagement.repository;

import com.sol.turismmanagement.model.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacesRepository extends JpaRepository<Places,Long> {
}

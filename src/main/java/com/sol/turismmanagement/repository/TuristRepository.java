package com.sol.turismmanagement.repository;

import com.sol.turismmanagement.model.Turist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuristRepository extends JpaRepository<Turist,Long> {
}

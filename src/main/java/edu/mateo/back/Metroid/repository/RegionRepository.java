package edu.mateo.back.Metroid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.mateo.back.Metroid.model.entities.Region;
import edu.mateo.back.Metroid.model.enumerated.Planet;

public interface RegionRepository extends JpaRepository<Region, Long> {
    @Query("SELECT r FROM Region r WHERE r.planet = :planet")
    List<Region> findByPlanet(@Param("planet") Planet planet);
}

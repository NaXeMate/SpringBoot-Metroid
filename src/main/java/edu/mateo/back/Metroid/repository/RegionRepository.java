package edu.mateo.back.Metroid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mateo.back.Metroid.model.entities.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {

}

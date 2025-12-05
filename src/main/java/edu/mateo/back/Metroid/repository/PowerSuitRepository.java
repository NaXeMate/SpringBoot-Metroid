package edu.mateo.back.Metroid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mateo.back.Metroid.model.entities.PowerSuit;

public interface PowerSuitRepository extends JpaRepository<PowerSuit, Long> {

}

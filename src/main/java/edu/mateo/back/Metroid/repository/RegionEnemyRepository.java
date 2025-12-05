package edu.mateo.back.Metroid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mateo.back.Metroid.model.entities.RegionEnemy;

public interface RegionEnemyRepository extends JpaRepository<RegionEnemy, Long> {}

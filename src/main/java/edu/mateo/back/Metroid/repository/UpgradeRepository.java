package edu.mateo.back.Metroid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mateo.back.Metroid.model.entities.Upgrade;

public interface UpgradeRepository extends JpaRepository<Upgrade, Long> {

}

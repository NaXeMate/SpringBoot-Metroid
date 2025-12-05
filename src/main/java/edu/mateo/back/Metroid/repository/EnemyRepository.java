package edu.mateo.back.Metroid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mateo.back.Metroid.model.entities.Enemy;

public interface EnemyRepository extends JpaRepository<Enemy, Long> {

}

package edu.mateo.back.Metroid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mateo.back.Metroid.model.entities.Enemy;
import edu.mateo.back.Metroid.model.enumerated.EnemyClass;

public interface EnemyRepository extends JpaRepository<Enemy, Long> {
    List<Enemy> findByEnemyClass(EnemyClass enemyClass);
}

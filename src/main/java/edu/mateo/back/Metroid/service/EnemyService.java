package edu.mateo.back.Metroid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mateo.back.Metroid.model.entities.Enemy;
import edu.mateo.back.Metroid.model.enumerated.EnemyClass;
import edu.mateo.back.Metroid.repository.EnemyRepository;
import edu.mateo.back.Metroid.service.interfaces.IEnemyService;

@Service
public class EnemyService implements IEnemyService {

    @Autowired
    private EnemyRepository enemyRepo;

    @Override
    public List<Enemy> getEnemies() {
        return enemyRepo.findAll();
    }

    @Override
    public Enemy getEnemyById(Long id) {
        Optional<Enemy> op = enemyRepo.findById(id);

        if (op.isPresent()) {
            return op.get();
        }

        return null;
    }

    @Override
    public Enemy updateEnemy(Enemy enemy) {
        if (enemy.getEnemy_Id() == null) {
            System.out.println("Enemy " + enemy.getName() + " added to the logbook.");
            return enemyRepo.save(enemy);
        } else {
            if (enemyRepo.existsById(enemy.getEnemy_Id())) {
                System.out.println("Enemy " + enemy.getName() + " logbook record updated.");
                return enemyRepo.save(enemy);
            } else {
                System.out.println("Enemy " + enemy.getName() + " is not saved into the logbook.");
                return null;
            }
        }
    }

    @Override
    public void deleteEnemy(Long id) {
        Enemy enemyToDelete = enemyRepo.findById(id).orElseThrow();
        enemyRepo.deleteById(id);
        System.out.println("Enemy " + enemyToDelete.getName() + " deleted from the logbook.");
    }

    @Override
    public List<Enemy> getEnemiesByClass(EnemyClass enemyClass) {
        return enemyRepo.findByEnemyClass(enemyClass);
    }
}

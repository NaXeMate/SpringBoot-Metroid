package edu.mateo.back.Metroid.service.interfaces;

import java.util.List;

import edu.mateo.back.Metroid.model.entities.Enemy;

public interface IEnemyService {
    public List<Enemy> getEnemies();
    public Enemy getEnemyById(Long id);
    public Enemy updateEnemy(Enemy enemy);
    public void deleteEnemy(Long id);

}

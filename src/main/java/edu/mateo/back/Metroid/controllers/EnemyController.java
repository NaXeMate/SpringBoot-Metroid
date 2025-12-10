package edu.mateo.back.Metroid.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mateo.back.Metroid.mapper.EnemyMapper;
import edu.mateo.back.Metroid.model.dto.EnemyDTO;
import edu.mateo.back.Metroid.model.entities.Enemy;
import edu.mateo.back.Metroid.model.enumerated.EnemyClass;
import edu.mateo.back.Metroid.service.EnemyService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/enemies")
public class EnemyController {

    @Autowired
    private EnemyService enemyService;

    @Autowired
    private EnemyMapper enemyMapper;

    @GetMapping
    public List<EnemyDTO> getAllEnemies() {
        return enemyService.getEnemies().stream().map(enemyMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public EnemyDTO getEnemyById(@PathVariable("id") Long id) {
        return enemyMapper.toDTO(enemyService.getEnemyById(id));
    }

    @PostMapping("/save")
    public EnemyDTO saveEnemy(@RequestBody EnemyDTO enemyDto) {
        Enemy enemy = enemyMapper.toEntity(enemyDto);

        enemy.setEnemy_Id(null);

        Enemy saved = enemyService.updateEnemy(enemy);
        
        return enemyMapper.toDTO(saved);
    }

    @PutMapping("/{id}")
    public EnemyDTO updateEnemy(@PathVariable("id") Long id, @RequestBody EnemyDTO enemyDto) {
        Enemy existingEnemy = enemyService.getEnemyById(id);

        if (existingEnemy == null) {
            throw new RuntimeException("Enemy with ID: " + id + "not founded in the logbook");
        }

        enemyMapper.updateEntityFromDTO(enemyDto, existingEnemy);

        existingEnemy.setEnemy_Id(id);

        Enemy uppdatedEnemy = enemyService.updateEnemy(existingEnemy);
        
        return enemyMapper.toDTO(uppdatedEnemy);
    }
    
    @DeleteMapping("/delete/{id}")
    public EnemyDTO deleteEnemy(@PathVariable("id") Long id) {
        Enemy deleted = enemyService.getEnemyById(id);

        if (deleted == null) {
            throw new RuntimeException("Enemy with ID: " + id + "not founded in the logbook");
        }

        enemyService.deleteEnemy(id);
        
        return enemyMapper.toDTO(deleted);
    }

    // ============
    // ENDPOINTS 
    // ============

    /**
     * Get enemies by its class
     */

    @GetMapping("/by-class/{enemyClass}")
    public List<EnemyDTO> getEnemiesByClass(@PathVariable("enemyClass") String enemyClass) {
        EnemyClass stringClass = EnemyClass.valueOf(enemyClass.toUpperCase());

        List<Enemy> enemies = enemyService.getEnemiesByClass(stringClass);
        
        return enemies.stream().map(enemyMapper::toDTO).toList();
    }

    /**
     * Get tactical info (description of the enemy's combat data)
     */

    @GetMapping("/{id}/tactical-info")
    public String getTacticalInfo(@PathVariable("id") Long id) {
        Enemy enemy = enemyService.getEnemyById(id);

        if (enemy == null) {
            throw new RuntimeException("Enemy with ID: " + id + "not founded in the logbook");
        }

        String tacticalInfo = enemy.getTacticalDescription();
        
        return tacticalInfo;
    }
}

package edu.mateo.back.Metroid.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "region_enemy")
public class RegionEnemy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regionEnemyId;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "enemy_id")
    private Enemy enemy;

    @Column(name = "number_defeated")
    private int numDefeated;

    @Column(name = "spawn_frequency")
    private int spawnFrequency;

    public RegionEnemy() {}

    public RegionEnemy(Long regionEnemyId, Region region, Enemy enemy, int numDefeated, int spawnFrequency) {
        this.regionEnemyId = regionEnemyId;
        this.region = region;
        this.enemy = enemy;
        this.numDefeated = numDefeated;
        this.spawnFrequency = spawnFrequency;
    }

    public RegionEnemy(Region region, Enemy enemy, int numDefeated, int spawnFrequency) {
        this.region = region;
        this.enemy = enemy;
        this.numDefeated = numDefeated;
        this.spawnFrequency = spawnFrequency;
    }

    public Long getRegionEnemyId() {
        return regionEnemyId;
    }

    public void setRegionEnemyId(Long regionEnemyId) {
        this.regionEnemyId = regionEnemyId;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public int getNumDefeated() {
        return numDefeated;
    }

    public void setNumDefeated(int numDefeated) {
        this.numDefeated = numDefeated;
    }

    public int getSpawnFrequency() {
        return spawnFrequency;
    }

    public void setSpawnFrequency(int spawnFrequency) {
        this.spawnFrequency = spawnFrequency;
    }

    @Override
    public String toString() {
        return "Register for the region " + region.getName() + " and the enemy" + enemy.getName() 
            + ".\n[\nNumber of enemies defeated: " + numDefeated
            + ";\nSpawn Frequency: " + spawnFrequency + ";\n]";
    }

    
}

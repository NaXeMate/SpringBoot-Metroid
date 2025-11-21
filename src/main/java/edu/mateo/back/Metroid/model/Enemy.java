package edu.mateo.back.Metroid.model;

import edu.mateo.back.Metroid.model.enumerated.EnemyClass;
import edu.mateo.back.Metroid.model.valueobjects.CombatStats;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "enemies")
public class Enemy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enemy_Id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "enemy_class", nullable = false)
    private EnemyClass enemyClass;

    @Column(name = "description", length = 500, nullable = true)
    private String description;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "healthPoints", column = @Column(name = "health_points", nullable = false)),
        @AttributeOverride(name = "attackPower", column = @Column(name = "attack_power", nullable = false)),
        @AttributeOverride(name = "speed", column = @Column(name = "speed", nullable = false)),
        @AttributeOverride(name = "dangerLevel", column = @Column(name = "danger_level", nullable = false))
    })
    private CombatStats stats;

    public Enemy() {}

    public Enemy(Long enemy_Id, String name, EnemyClass enemyClass, String description, CombatStats stats) {
        this.enemy_Id = enemy_Id;
        this.name = name;
        this.enemyClass = enemyClass;
        this.description = description;
        this.stats = stats;
    }

    public Enemy(String name, EnemyClass enemyClass, String description, CombatStats stats) {
        this.name = name;
        this.enemyClass = enemyClass;
        this.description = description;
        this.stats = stats;
    }

    public Long getEnemy_Id() {
        return enemy_Id;
    }

    public void setEnemy_Id(Long enemy_Id) {
        this.enemy_Id = enemy_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnemyClass getEnemyClass() {
        return enemyClass;
    }

    public void setEnemyClass(EnemyClass enemyClass) {
        this.enemyClass = enemyClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CombatStats getStats() {
        return stats;
    }

    public void setStats(CombatStats stats) {
        this.stats = stats;
    }


}

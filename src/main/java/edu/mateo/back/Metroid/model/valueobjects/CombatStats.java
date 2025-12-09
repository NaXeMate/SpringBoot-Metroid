package edu.mateo.back.Metroid.model.valueobjects;

import java.util.Objects;

public final class CombatStats {

    private final Integer healthPoints;
    private final Integer attackPower;
    private final Double speed;
    private final Integer dangerLevel;

    public CombatStats(Integer healthPoints, Integer attackPower, Double speed, Integer dangerLevel) {
        if (healthPoints == null || healthPoints < 0) {
            throw new IllegalArgumentException("Health points cannot be null or negative.");
        }
        if (attackPower == null || attackPower < 0) {
            throw new IllegalArgumentException("Attack power cannot be null or negative.");
        }
        if (speed == null || speed < 0.0) {
            throw new IllegalArgumentException("Speed cannot be null or negative.");
        }
        if (dangerLevel == null || dangerLevel < 0 || dangerLevel > 10) {
            throw new IllegalArgumentException("Danger level must be between 0 and 10.");
        }

        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
        this.speed = speed;
        this.dangerLevel = dangerLevel;
    }

    protected CombatStats() {
        this.healthPoints = 0;
        this.attackPower = 0;
        this.speed = 0.0;
        this.dangerLevel = 0;
    }

    public double timeToDefeat(int samusDPS) {
        if (samusDPS <= 0 || healthPoints == null || healthPoints <= 0) {
            return 0.0;
        }
        return (double) healthPoints / samusDPS;
    }

    public int hitsToDefeat(int samusDamage) {
        if (samusDamage <= 0 || healthPoints == null || healthPoints <= 0) {
            return 0;
        }
        return (int) Math.ceil((double) healthPoints / samusDamage);
    }

    public boolean isDangerous() {
        return dangerLevel != null && dangerLevel >= 7;
    }

    public double calculateCombatPower() {
        if (healthPoints == null || attackPower == null || 
            speed == null || dangerLevel == null) {
            return 0.0;
        }
        
        return (healthPoints * 0.5) + 
               (attackPower * 2.0) + 
               (speed * 10.0) + 
               (dangerLevel * 20.0);
    }

    public int compareStrengthWithEnemy(CombatStats otherEnemyStats) {
        if (otherEnemyStats == null) return 1;
        
        double thisPower = this.calculateCombatPower();
        double otherPower = otherEnemyStats.calculateCombatPower();
        
        if (thisPower > otherPower * 1.1) return 1;
        if (thisPower < otherPower * 0.9) return -1;
        return 0;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }
    
    public Integer getAttackPower() {
        return attackPower;
    }
    
    public Double getSpeed() {
        return speed;
    }
    
    public Integer getDangerLevel() {
        return dangerLevel;
    }    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CombatStats that = (CombatStats) o;
        return Objects.equals(healthPoints, that.healthPoints) &&
               Objects.equals(attackPower, that.attackPower) &&
               Objects.equals(speed, that.speed) &&
               Objects.equals(dangerLevel, that.dangerLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(healthPoints, attackPower, speed, dangerLevel);
    }
}
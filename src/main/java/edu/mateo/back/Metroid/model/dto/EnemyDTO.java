package edu.mateo.back.Metroid.model.dto;

public record EnemyDTO(
    String name,
    String enemyClass,
    String description,
    Integer healthPoints,
    Integer attackPower,
    Double speed,
    Integer dangerLevel
) {}

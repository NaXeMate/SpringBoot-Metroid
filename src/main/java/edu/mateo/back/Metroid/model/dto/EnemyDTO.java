package edu.mateo.back.Metroid.model.dto;

import edu.mateo.back.Metroid.model.enumerated.EnemyClass;

public record EnemyDTO(
    String name,
    EnemyClass enemyClass,
    String description,
    Integer healthPoints,
    Integer attackPower,
    Double speed,
    Integer dangerLevel
) {}

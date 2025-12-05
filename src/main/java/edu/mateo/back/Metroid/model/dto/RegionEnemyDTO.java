package edu.mateo.back.Metroid.model.dto;

public record RegionEnemyDTO(
    String region,
    String enemy,
    int numDefeated
) {}

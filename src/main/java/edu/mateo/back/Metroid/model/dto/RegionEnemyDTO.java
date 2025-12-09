package edu.mateo.back.Metroid.model.dto;

import edu.mateo.back.Metroid.model.entities.Enemy;
import edu.mateo.back.Metroid.model.entities.Region;

public record RegionEnemyDTO(
    Region region,
    Enemy enemy,
    int numDefeated
) {}

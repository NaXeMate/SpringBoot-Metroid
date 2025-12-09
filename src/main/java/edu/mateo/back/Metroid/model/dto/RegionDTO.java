package edu.mateo.back.Metroid.model.dto;

import edu.mateo.back.Metroid.model.enumerated.Biome;
import edu.mateo.back.Metroid.model.enumerated.Climate;
import edu.mateo.back.Metroid.model.enumerated.Planet;

public record RegionDTO(
    String name,
    Planet planet,
    Biome biome,
    int difficultyLevel,
    Climate climate,
    Double latitude,
    Integer altitude,
    Double longitude
) {

}

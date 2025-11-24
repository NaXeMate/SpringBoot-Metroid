package edu.mateo.back.Metroid.model.dto;

public record RegionDTO(
    String name,
    String planet,
    String biome,
    int difficultyLevel,
    String climate,
    Double latitude,
    Integer altitude,
    Double longitude
) {

}

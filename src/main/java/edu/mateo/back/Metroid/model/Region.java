package edu.mateo.back.Metroid.model;

import edu.mateo.back.Metroid.model.enumerated.Biome;
import edu.mateo.back.Metroid.model.enumerated.Climate;
import edu.mateo.back.Metroid.model.enumerated.Planet;
import edu.mateo.back.Metroid.model.valueobjects.Coordinates;

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
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long region_Id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "planet", nullable = false)
    private Planet planet;

    @Column(name = "biome", nullable = false)
    private Biome biome;

    @Column(name = "difficulty_level", nullable = false)
    private int difficultyLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "climate", nullable = false)
    private Climate climate;

    @Column(name = "exploration_percentage", nullable = false)
    private double explorationPercentage;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "latitude", column = @Column(name = "latitude", nullable = false)),
        @AttributeOverride(name = "altitude", column = @Column(name = "altitude", nullable = false)),
        @AttributeOverride(name = "longitude", column = @Column(name = "longitude", nullable = false))
    })
    @Column(name = "coordinates", nullable = false)
    private Coordinates coordinates;

    public Region() {}

    public Region(Long region_Id, String name, Planet planet, Biome biome, int difficultyLevel, Climate climate,
                  double explorationPercentage, Coordinates coordinates) {
        
        if (explorationPercentage < 0.0 || explorationPercentage > 100.0) {
            throw new IllegalArgumentException("Exploration percentage must be between 0 and 100.");
        }

        if (coordinates.getLatitude() >= 0 && coordinates.getLatitude() <= 23.5) {
            this.climate = Climate.ARID;
        } else if (coordinates.getLatitude() >= 23.5 && coordinates.getLatitude() <= 40.0) {
            this.climate = Climate.TROPICAL;
        } else if (coordinates.getLatitude() >= 40.0 && coordinates.getLatitude() <= 60.0) {
            this.climate = Climate.TEMPERATE;
        } else if (coordinates.getLatitude() >= 60.0 && coordinates.getLatitude() <= 75.0) {
            this.climate = Climate.CONTINENTAL;
        } else {
            this.climate = Climate.POLAR;
        }
        
        this.region_Id = region_Id;
        this.name = name;
        this.planet = planet;
        this.biome = biome;
        this.difficultyLevel = difficultyLevel;
        this.explorationPercentage = explorationPercentage;
        this.coordinates = coordinates;
    }

    public Region(String name, Planet planet, Biome biome, int difficultyLevel, Climate climate,
                  double explorationPercentage, Coordinates coordinates) {
        
        if (explorationPercentage < 0.0 || explorationPercentage > 100.0) {
            throw new IllegalArgumentException("Exploration percentage must be between 0 and 100.");
        }

        if (coordinates.getLatitude() >= 0 && coordinates.getLatitude() <= 23.5) {
            this.climate = Climate.ARID;
        } else if (coordinates.getLatitude() >= 23.5 && coordinates.getLatitude() <= 40.0) {
            this.climate = Climate.TROPICAL;
        } else if (coordinates.getLatitude() >= 40.0 && coordinates.getLatitude() <= 60.0) {
            this.climate = Climate.TEMPERATE;
        } else if (coordinates.getLatitude() >= 60.0 && coordinates.getLatitude() <= 75.0) {
            this.climate = Climate.CONTINENTAL;
        } else {
            this.climate = Climate.POLAR;
        }

        this.name = name;
        this.planet = planet;
        this.biome = biome;
        this.difficultyLevel = difficultyLevel;
        this.explorationPercentage = explorationPercentage;
        this.coordinates = coordinates;
    }

    public Long getRegion_Id() {
        return region_Id;
    }

    public void setRegion_Id(Long region_Id) {
        this.region_Id = region_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Biome getBiome() {
        return biome;
    }

    public void setBiome(Biome biome) {
        this.biome = biome;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public double getExplorationPercentage() {
        return explorationPercentage;
    }

    public void setExplorationPercentage(double explorationPercentage) {
        if (explorationPercentage < 0.0 || explorationPercentage > 100.0) {
            throw new IllegalArgumentException("Exploration percentage must be between 0 and 100.");
        }
        
        this.explorationPercentage = explorationPercentage;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    
}

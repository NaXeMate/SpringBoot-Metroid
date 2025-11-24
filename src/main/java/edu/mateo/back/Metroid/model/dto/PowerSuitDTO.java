package edu.mateo.back.Metroid.model.dto;

import java.time.LocalDate;
import java.util.List;

public record PowerSuitDTO(
    String name,
    LocalDate installationDate,
    int energyTanks,
    int reserveTanks,
    int damageReduction,
    boolean heatResistance,
    boolean radiationResistance,
    List<UpgradeDTO> upgrades
    
) {}

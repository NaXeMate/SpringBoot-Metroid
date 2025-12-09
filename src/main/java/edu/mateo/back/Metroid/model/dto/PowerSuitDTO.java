package edu.mateo.back.Metroid.model.dto;

import java.time.LocalDate;
import java.util.List;

public record PowerSuitDTO(
    String name,
    LocalDate installationDate,
    Integer energyTanks,
    Integer reserveTanks,
    Integer damageReduction,
    boolean heatResistance,
    boolean radiationResistance,
    List<Long> installedUpgradesId
) {}

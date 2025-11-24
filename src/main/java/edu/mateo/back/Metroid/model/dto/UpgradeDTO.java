package edu.mateo.back.Metroid.model.dto;

import java.util.List;

public record UpgradeDTO(
    String name,
    String upgradeClass,
    String description,
    String energyType,
    String techOrigin,
    List<UpgradeDTO> requiredUpgrades
) {}

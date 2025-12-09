package edu.mateo.back.Metroid.model.dto;

import edu.mateo.back.Metroid.model.enumerated.EnergyType;
import edu.mateo.back.Metroid.model.enumerated.TechOrigin;
import edu.mateo.back.Metroid.model.enumerated.UpgradeClass;

public record UpgradeDTO(
    String name,
    UpgradeClass upgradeClass,
    String description,
    EnergyType energyType,
    TechOrigin techOrigin,
    Long requiredUpgradeId
) {}

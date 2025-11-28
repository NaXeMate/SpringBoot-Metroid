package edu.mateo.back.Metroid.model;

import edu.mateo.back.Metroid.model.enumerated.EnergyType;
import edu.mateo.back.Metroid.model.enumerated.TechOrigin;
import edu.mateo.back.Metroid.model.enumerated.UpgradeClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "upgrades")
public class Upgrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long upgrade_Id;

    @Column(nullable = false)
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "upgrade_class", nullable = false)
    private UpgradeClass upgradeClass;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "energy_type", nullable = true)
    private EnergyType energyType;

    @Enumerated(EnumType.STRING)
    @Column(name = "tech_origin", nullable = false)
    private TechOrigin techOrigin;

    @Column(name = "upgrade_requirements", nullable = true)
    private Upgrade requiredUpgrade;

    public Upgrade() {}

    public Upgrade(String name, UpgradeClass upgradeClass, String description, EnergyType energyType,
                   TechOrigin techOrigin, Upgrade requiredUpgrade) {
        this.name = name;
        this.upgradeClass = upgradeClass;
        this.description = description;
        this.energyType = energyType;
        this.techOrigin = techOrigin;
        this.requiredUpgrade = requiredUpgrade;
    }

    public Upgrade(Long upgrade_Id, String name, UpgradeClass upgradeClass, String description, EnergyType energyType,
            TechOrigin techOrigin, Upgrade requiredUpgrade) {
        this.upgrade_Id = upgrade_Id;
        this.name = name;
        this.upgradeClass = upgradeClass;
        this.description = description;
        this.energyType = energyType;
        this.techOrigin = techOrigin;
        this.requiredUpgrade = requiredUpgrade;
    }

    public Long getUpgrade_Id() {
        return upgrade_Id;
    }

    public void setUpgrade_Id(Long upgrade_Id) {
        this.upgrade_Id = upgrade_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UpgradeClass getUpgradeClass() {
        return upgradeClass;
    }

    public void setUpgradeClass(UpgradeClass upgradeClass) {
        this.upgradeClass = upgradeClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(EnergyType energyType) {
        this.energyType = energyType;
    }

    public TechOrigin getTechOrigin() {
        return techOrigin;
    }

    public void setTechOrigin(TechOrigin techOrigin) {
        this.techOrigin = techOrigin;
    }

    public Upgrade getRequiredUpgrade() {
        return requiredUpgrade;
    }

    public void setRequiredUpgrade(Upgrade requiredUpgrade) {
        this.requiredUpgrade = requiredUpgrade;
    }

    
}

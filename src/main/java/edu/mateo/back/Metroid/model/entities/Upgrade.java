package edu.mateo.back.Metroid.model.entities;

import java.util.ArrayList;
import java.util.List;

import edu.mateo.back.Metroid.model.enumerated.EnergyType;
import edu.mateo.back.Metroid.model.enumerated.TechOrigin;
import edu.mateo.back.Metroid.model.enumerated.UpgradeClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "upgrades")
public class Upgrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long upgrade_id;

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
    @Column(name = "tech_origin", nullable = false, length = 50)
    private TechOrigin techOrigin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "required_upgrade_id")
    private Upgrade requiredUpgrade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "power_suit_id")
    private PowerSuit powerSuit;

    @ManyToMany
    @JoinTable(
        name = "region_upgrade",
        joinColumns = @JoinColumn(name = "upgrade_id"),
        inverseJoinColumns = @JoinColumn(name = "region_id"))
    private List<Region> locations = new ArrayList<>();

    public Upgrade() {}

    public Upgrade(Long upgrade_id, String name, UpgradeClass upgradeClass, String description, EnergyType energyType,
            TechOrigin techOrigin, Upgrade requiredUpgrade, PowerSuit powerSuit, List<Region> locations) {
        this.upgrade_id = upgrade_id;
        this.name = name;
        this.upgradeClass = upgradeClass;
        this.description = description;
        this.energyType = energyType;
        this.techOrigin = techOrigin;
        this.requiredUpgrade = requiredUpgrade;
        this.powerSuit = powerSuit;
        this.locations = locations;
    }

    public Upgrade(String name, UpgradeClass upgradeClass, String description, EnergyType energyType,
            TechOrigin techOrigin, Upgrade requiredUpgrade, PowerSuit powerSuit, List<Region> locations) {
        this.name = name;
        this.upgradeClass = upgradeClass;
        this.description = description;
        this.energyType = energyType;
        this.techOrigin = techOrigin;
        this.requiredUpgrade = requiredUpgrade;
        this.powerSuit = powerSuit;
        this.locations = locations;
    }

    public Long getUpgrade_id() {
        return upgrade_id;
    }

    public void setUpgrade_id(Long upgrade_id) {
        this.upgrade_id = upgrade_id;
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

    public PowerSuit getPowerSuit() {
        return powerSuit;
    }

    public void setPowerSuit(PowerSuit powerSuit) {
        this.powerSuit = powerSuit;
    }

    public List<Region> getLocations() {
        return locations;
    }

    public void setLocations(List<Region> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Upgrade " + name + ":\n[\nClass: " + upgradeClass + ";\nDescription: " + description
                + ";\nEnergy Type: " + energyType + ";\nOrigin: " + techOrigin 
                + ";\nRequired Upgrade: " + requiredUpgrade + "\nLocations: " + locations
                + ";\n]";
    }
}

package edu.mateo.back.Metroid.model.entities;

import java.time.LocalDate;
import java.util.List;

import edu.mateo.back.Metroid.model.valueobjects.DefenseRating;
import edu.mateo.back.Metroid.model.valueobjects.EnergyStatus;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "power_suit")
public class PowerSuit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long powerSuit_Id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "installation_date")
    private LocalDate installationDate;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "energy_tanks", column = @Column(name = "energy_tanks", nullable = false)),
        @AttributeOverride(name = "reserve_tanks", column = @Column(name = "reserve_tanks", nullable = true)),
        @AttributeOverride(name = "current_energy", column = @Column(name = "current_energy", nullable = false)),
        @AttributeOverride(name = "max_energy", column = @Column(name = "max_energy", nullable = false))
    })
    private EnergyStatus energyStatus;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "damage_reduction", column = @Column(name = "damage_reduction", nullable = false)),
        @AttributeOverride(name = "heat_resistance", column = @Column(name = "heat_resistance", nullable = false)),
        @AttributeOverride(name = "radiation_resistance", column = @Column(name = "radiation_resistance", nullable = false))
    })
    private DefenseRating defenseRating;

    
    @OneToMany(mappedBy = "powerSuit", fetch = FetchType.LAZY)
    private List<Upgrade> upgrades;

    public PowerSuit() {}

    public PowerSuit(Long powerSuit_Id, String name, LocalDate installationDate, EnergyStatus energyStatus,
                     DefenseRating defenseRating, List<Upgrade> upgrades) {
        this.powerSuit_Id = powerSuit_Id;
        this.name = name;
        this.installationDate = installationDate;
        this.energyStatus = energyStatus;
        this.defenseRating = defenseRating;
        this.upgrades = upgrades;
    }

    public PowerSuit(String name, LocalDate installationDate, EnergyStatus energyStatus,
                     DefenseRating defenseRating, List<Upgrade> upgrades) {
        this.name = name;
        this.installationDate = installationDate;
        this.energyStatus = energyStatus;
        this.defenseRating = defenseRating;
        this.upgrades = upgrades;
    }

    public Long getPowerSuit_Id() {
        return powerSuit_Id;
    }

    public void setPowerSuit_Id(Long powerSuit_Id) {
        this.powerSuit_Id = powerSuit_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(LocalDate installationDate) {
        this.installationDate = installationDate;
    }

    public EnergyStatus getEnergyStatus() {
        return energyStatus;
    }

    public void setEnergyStatus(EnergyStatus energyStatus) {
        this.energyStatus = energyStatus;
    }

    public DefenseRating getDefenseRating() {
        return defenseRating;
    }

    public void setDefenseRating(DefenseRating defenseRating) {
        this.defenseRating = defenseRating;
    }

    public List<Upgrade> getUpgrades() {
        return upgrades;
    }

    public void setUpgrades(List<Upgrade> upgrades) {
        this.upgrades = upgrades;
    }

    @Override
    public String toString() {
        return "Suit " + name + ":\n[\nInstallation Date: " + installationDate + ";\nCurrent energy level: " + energyStatus.getCurrentEnergy()
                + ";\nEnergy Tanks acquired: " + energyStatus.getEnergyTanks() + ";\nReserve Tanks acquired: " + energyStatus.getReserveTanks()
                + ";\nHeat Resistance: " + defenseRating.isHeatResistance() + ";\nRadiation Resistance: " + defenseRating.isRadiationResistance()
                + ";\nUpgrades acquired: " + upgrades + ";\n]";
    }
}

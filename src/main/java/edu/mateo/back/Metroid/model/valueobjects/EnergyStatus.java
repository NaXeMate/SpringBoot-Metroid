package edu.mateo.back.Metroid.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public final class EnergyStatus {

    private final Integer energyTanks;
    private final Integer reserveTanks;
    private final Integer currentEnergy;
    private final Integer maxEnergy;

    public EnergyStatus(Integer energyTanks, Integer reserveTanks, Integer currentEnergy, Integer maxEnergy) {
        
        maxEnergy = (energyTanks * 100) + 99;
        
        if (maxEnergy < 99) {
            throw new IllegalArgumentException("The Power Suit has its own Energy Tank, which has 99 energy units. Each aditional tank provides 100 energy units.");
        }

        if (currentEnergy > maxEnergy) {
            throw new IllegalArgumentException("Current energy cannot exceed the maximum energy capacity.");
        }

        if (reserveTanks < 0) {
            throw new IllegalArgumentException("Reserve tanks cannot be negative.");
        }

        if (reserveTanks > energyTanks/2) {
            throw new IllegalArgumentException("Reserve tanks cannot exceed half of the total energy tanks.");
        }
        
        this.energyTanks = energyTanks;
        this.reserveTanks = reserveTanks;
        this.currentEnergy = currentEnergy;
        this.maxEnergy = maxEnergy;
    }
    
    protected EnergyStatus() {
        this.energyTanks = 0;
        this.reserveTanks = 0;
        this.currentEnergy = 0;
        this.maxEnergy = 0;
    }

    public Integer getEnergyTanks() {
        return energyTanks;
    }

    public Integer getReserveTanks() {
        return reserveTanks;
    }

    public Integer getCurrentEnergy() {
        return currentEnergy;
    }

    public Integer getMaxEnergy() {
        return maxEnergy;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + energyTanks;
        result = prime * result + reserveTanks;
        result = prime * result + currentEnergy;
        result = prime * result + maxEnergy;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EnergyStatus other = (EnergyStatus) obj;
        if (energyTanks != other.energyTanks)
            return false;
        if (reserveTanks != other.reserveTanks)
            return false;
        if (currentEnergy != other.currentEnergy)
            return false;
        if (maxEnergy != other.maxEnergy)
            return false;
        return true;
    }

    
}

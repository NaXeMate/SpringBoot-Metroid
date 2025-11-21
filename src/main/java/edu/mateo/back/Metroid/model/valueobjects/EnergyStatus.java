package edu.mateo.back.Metroid.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public final class EnergyStatus {

    private final int energyTanks;
    private final int reserveTanks;
    private final int currentEnergy;
    private final int maxEnergy;

    public EnergyStatus(int energyTanks, int reserveTanks, int currentEnergy, int maxEnergy) {
        if (energyTanks <= 0 || maxEnergy <= 99) {
            throw new IllegalArgumentException("One energy tank is required for the Power Suit in order to function properly. Each tank provides 99 energy units.");
        }

        if (currentEnergy > maxEnergy) {
            throw new IllegalArgumentException("Current energy cannot exceed maximum energy capacity.");
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

    public int getEnergyTanks() {
        return energyTanks;
    }

    public int getReserveTanks() {
        return reserveTanks;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public int getMaxEnergy() {
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

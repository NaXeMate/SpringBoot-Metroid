package edu.mateo.back.Metroid.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public final class DefenseRating {

    private final int damageReduction;
    private final boolean heatResistance;
    private final boolean radiationResistance;

    public DefenseRating(int damageReduction, boolean heatResistance, boolean radiationResistance) {
        if (damageReduction < 30) {
            throw new IllegalArgumentException("The Power Suit provides a minimum of 30% damage reduction.");
        }

        if (damageReduction == 30 && heatResistance || radiationResistance) {
            throw new IllegalArgumentException("The Power Suit does not provide any enviromental protection.");
        }

        if (damageReduction == 50 && !heatResistance) {
            throw new IllegalArgumentException("The Varia Suit provides heat resistance and 50% damage reduction.");
        }

        if (damageReduction == 70 && (!heatResistance)) {
            throw new IllegalArgumentException("The Gravity Suit provides heat resistance.");
        }

        if (damageReduction != 75 && radiationResistance) {
            throw new IllegalArgumentException("The only suit that provides radiation resistance is the Phazon Suit.");
        }

        if (damageReduction == 75 && (!heatResistance || !radiationResistance)) {
            throw new IllegalArgumentException("The Phazon Suit provides heat and radiation resistance, along with 75% damage reduction.");
        }

        if (damageReduction != 30 && damageReduction != 50 && damageReduction != 70 && damageReduction != 75) {
            throw new IllegalArgumentException("Invalid damage reduction value for any known suit.");
        }
  
        this.damageReduction = damageReduction;
        this.heatResistance = heatResistance;
        this.radiationResistance = radiationResistance;
    }

    protected DefenseRating() {
        this.damageReduction = 0;
        this.heatResistance = false;
        this.radiationResistance = false;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public boolean isHeatResistance() {
        return heatResistance;
    }

    public boolean isRadiationResistance() {
        return radiationResistance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + damageReduction;
        result = prime * result + (heatResistance ? 1231 : 1237);
        result = prime * result + (radiationResistance ? 1231 : 1237);
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
        DefenseRating other = (DefenseRating) obj;
        if (damageReduction != other.damageReduction)
            return false;
        if (heatResistance != other.heatResistance)
            return false;
        if (radiationResistance != other.radiationResistance)
            return false;
        return true;
    }

    
}
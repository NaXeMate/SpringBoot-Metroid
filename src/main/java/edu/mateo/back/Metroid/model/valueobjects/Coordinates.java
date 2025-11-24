package edu.mateo.back.Metroid.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public final class Coordinates {
    private final Double latitude;
    private final Integer altitude;
    private final Double longitude;

    public Coordinates(Double latitude, Integer altitude, Double longitude) {
        if (latitude == 0.0 || longitude == 0.0 || altitude == 0) {
            throw new IllegalArgumentException("Coordinates cannot be null or zero.");
        }
        if (latitude < -90.0 || latitude > 90.0) {
            throw new IllegalArgumentException("Latitude must be between -90 and 90.");
        }
        if (longitude < -180.0 || longitude > 180.0) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180.");
        }
        if (altitude < -11000 || altitude > 9000) {
            throw new IllegalArgumentException("Altitude out of planetary range.");
        }
        
        this.latitude = latitude;
        this.altitude = altitude;
        this.longitude = longitude;
    }

    protected Coordinates() {
        this.latitude = 0.0;
        this.altitude = 0;
        this.longitude = 0.0;
    }

    public double distanceTo (Coordinates coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Coordinates to compare cannot be null.");
        }

        double lat1Rad = Math.toRadians(this.latitude);
        double lat2Rad = Math.toRadians(this.altitude);
        double deltaLat = Math.toRadians(coordinates.latitude - this.latitude);
        double deltaLong = Math.toRadians(coordinates.longitude - this.longitude);

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                   Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                   Math.sin(deltaLong / 2) * Math.sin(deltaLong / 2);
        
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        final double PLANET_RADIUS = 6371.0;
        return PLANET_RADIUS * c;
    }

    public boolean isUnderwater() {
        return altitude < 0;
    }

    public boolean isNorthernHemisphere() {
        return latitude >= 0;
    }

    public boolean isNearby(Coordinates coordinates) {
        return distanceTo(coordinates) <= 50.0;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(altitude);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((longitude == 0.0) ? 0 : longitude.hashCode());
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
        Coordinates other = (Coordinates) obj;
        if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
            return false;
        if (Double.doubleToLongBits(altitude) != Double.doubleToLongBits(other.altitude))
            return false;
        if (longitude == null) {
            if (other.longitude != null)
                return false;
        } else if (!longitude.equals(other.longitude))
            return false;
        return true;
    }

    
}

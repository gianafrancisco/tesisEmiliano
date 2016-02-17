package utn.emiliano.model;

/**
 * Created by francisco on 17/02/2016.
 */
public class Coordinate {
    private double lat;
    private double lng;

    public Coordinate(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}

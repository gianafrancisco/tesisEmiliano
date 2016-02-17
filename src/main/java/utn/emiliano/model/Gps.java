package utn.emiliano.model;

/**
 * Created by francisco on 17/02/2016.
 */
public class Gps {
    private long dni;
    private Coordinate gps;
    private String marker;

    public Gps(long dni, double lat, double lng, String marker) {
        this.dni = dni;
        this.gps = new Coordinate(lat, lng);
        this.marker = marker;
    }

    public long getDni() {
        return dni;
    }

    public Coordinate getGps() {
        return gps;
    }

    public String getMarker() {
        return marker;
    }
}

package utn.emiliano.model;

import java.time.Instant;

/**
 * Created by francisco on 17/02/2016.
 */
public class Ticket {
    private long dni;
    private Instant fecha;
    private String conductor;
    private String remito;
    private String tambo;
    private int sisterna;
    private String antibiotico;
    private double litros;
    private double temperatura;

    public Ticket(long dni, Instant fecha, String conductor, String remito, String tambo, int sisterna, String antibiotico, double litros, double temperatura) {
        this.dni = dni;
        this.fecha = fecha;
        this.conductor = conductor;
        this.remito = remito;
        this.tambo = tambo;
        this.sisterna = sisterna;
        this.antibiotico = antibiotico;
        this.litros = litros;
        this.temperatura = temperatura;
    }

    public String getAntibiotico() {
        return antibiotico;
    }

    public long getDni() {
        return dni;
    }

    public Instant getFecha() {
        return fecha;
    }

    public String getConductor() {
        return conductor;
    }

    public String getRemito() {
        return remito;
    }

    public String getTambo() {
        return tambo;
    }

    public int getSisterna() {
        return sisterna;
    }

    public double getLitros() {
        return litros;
    }

    public double getTemperatura() {
        return temperatura;
    }
}

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
    private int cisterna;
    private String antibiotico;
    private double litros;
    private double temperatura;

    public Ticket(long dni, Instant fecha, String conductor, String remito, String tambo, int cisterna, String antibiotico, double litros, double temperatura) {
        this.dni = dni;
        this.fecha = fecha;
        this.conductor = conductor;
        this.remito = remito;
        this.tambo = tambo;
        this.cisterna = cisterna;
        this.antibiotico = antibiotico;
        this.litros = litros;
        this.temperatura = temperatura;
    }

    public Ticket() {
        this.fecha = Instant.now();
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

    public int getCisterna() {
        return cisterna;
    }

    public double getLitros() {
        return litros;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public void setRemito(String remito) {
        this.remito = remito;
    }

    public void setTambo(String tambo) {
        this.tambo = tambo;
    }

    public void setCisterna(int cisterna) {
        this.cisterna = cisterna;
    }

    public void setAntibiotico(String antibiotico) {
        this.antibiotico = antibiotico;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
}

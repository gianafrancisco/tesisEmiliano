package utn.emiliano.model;

/**
 * Created by francisco on 17/02/2016.
 */
public class User {
    private long dni;
    private String patente;
    private String nombre;
    private String apellido;
    private String empresa;

    public User(long dni, String patente, String nombre, String apellido, String empresa) {
        this.dni = dni;
        this.patente = patente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.empresa = empresa;
    }

    public long getDni() {
        return dni;
    }

    public String getPatente() {
        return patente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmpresa() {
        return empresa;
    }
}

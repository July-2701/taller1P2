package modelo.abstractas;

import java.time.LocalDate;
import modelo.excepciones.DatoInvalidoException;

public abstract class Persona {

    protected String id;
    protected String nombre;
    protected String apellido;
    protected LocalDate fechaNacimiento;
    protected String email;

    public Persona(String id, String nombre, String apellido,
                   LocalDate fechaNacimiento, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public abstract int calcularEdad();
    public abstract String obtenerTipo();
    public abstract String obtenerDocumentoIdentidad();
}
package modelo.abstractas;

import java.time.LocalDate;

public abstract class Empleado extends Persona {

    private String legajo;
    private LocalDate fechaContratacion;
    protected double salarioBase;
    private boolean activo;
    
    public Empleado(String id, String nombre, String apellido,
                    LocalDate fechaNacimiento, String email,
                    String legajo, LocalDate fechaContratacion,
                    double salarioBase) {

        super(id, nombre, apellido, fechaNacimiento, email);
        this.legajo = legajo;
        this.fechaContratacion = fechaContratacion;
        this.salarioBase = salarioBase;
        this.activo = true;
    }

    public abstract double calcularSalario();
    public abstract double calcularBono();

    @Override
    public int calcularEdad() {
        LocalDate hoy = LocalDate.now();
        int edad = hoy.getYear() - getFechaNacimiento().getYear();

        if (hoy.getDayOfYear() < getFechaNacimiento().getDayOfYear()) {
            edad--;
        }

        return edad;
}

    public int calcularAntiguedad() {
        return LocalDate.now().getYear() - fechaContratacion.getYear();
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public String getLegajo() {
        return legajo;
    }

    public boolean isActivo() {
        return activo;
    }
}
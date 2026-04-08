package modelo.empleados;

import modelo.abstractas.Empleado;
import java.time.LocalDate;

public class Cajero extends Empleado {

    private int transaccionesDia;

    public Cajero(String id, String nombre, String apellido,
                  LocalDate fechaNacimiento, String email,
                  String legajo, LocalDate fechaContratacion,
                  double salarioBase) {

        super(id, nombre, apellido, fechaNacimiento, email,
              legajo, fechaContratacion, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + calcularBono();
    }

    @Override
    public double calcularBono() {
        return transaccionesDia * 10;
    }

    @Override
    public String obtenerTipo() {
        return "Cajero";
    }

    @Override
    public String obtenerDocumentoIdentidad() {
        return "CAJ-" + getLegajo();
    }
}
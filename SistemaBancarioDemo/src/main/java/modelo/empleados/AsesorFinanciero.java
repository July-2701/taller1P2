package modelo.empleados;

import modelo.abstractas.Empleado;
import java.time.LocalDate;

public class AsesorFinanciero extends Empleado {

    private double metasMensuales;

    public AsesorFinanciero(String id, String nombre, String apellido,
                            LocalDate fechaNacimiento, String email,
                            String legajo, LocalDate fechaContratacion,
                            double salarioBase, double metasMensuales) {

        super(id, nombre, apellido, fechaNacimiento, email,
              legajo, fechaContratacion, salarioBase);

        this.metasMensuales = metasMensuales;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + calcularBono();
    }

    @Override
    public double calcularBono() {
        if (metasMensuales >= 10000) {
            return 500;
        }
        return 0;
    }

    @Override
    public String obtenerTipo() {
        return "Asesor Financiero";
    }

    @Override
    public String obtenerDocumentoIdentidad() {
        return "ASE-" + getLegajo();
    }
}
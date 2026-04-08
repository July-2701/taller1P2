package modelo.empleados;

import modelo.abstractas.Empleado;
import modelo.interfaces.Consultable;
import modelo.interfaces.Auditable;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GerenteSucursal extends Empleado implements Consultable, Auditable {

    private String sucursal;
    private double presupuestoAnual;
    private Empleado[] empleadosACargo;

    private LocalDateTime fechaCreacion;
    private LocalDateTime ultimaModificacion;
    private String usuarioModificacion;

    public GerenteSucursal(String id, String nombre, String apellido,
                           LocalDate fechaNacimiento, String email,
                           String legajo, LocalDate fechaContratacion,
                           double salarioBase,
                           String sucursal, double presupuestoAnual) {

        super(id, nombre, apellido, fechaNacimiento, email,
              legajo, fechaContratacion, salarioBase);

        this.sucursal = sucursal;
        this.presupuestoAnual = presupuestoAnual;
        this.empleadosACargo = new Empleado[30];

        this.fechaCreacion = LocalDateTime.now();
        this.ultimaModificacion = LocalDateTime.now();
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + calcularBono();
    }

    @Override
    public double calcularBono() {
        return 1000 + (calcularAntiguedad() * 100);
    }

    @Override
    public String obtenerTipo() {
        return "Gerente de Sucursal";
    }

    @Override
    public String obtenerDocumentoIdentidad() {
        return "LEG-" + getLegajo();
    }

    @Override
    public String obtenerResumen() {
        return "Gerente: " + getNombreCompleto() +
               " | Sucursal: " + sucursal +
               " | Presupuesto: " + presupuestoAnual;
    }

    @Override
    public boolean estaActivo() {
        return true;
    }

    @Override
    public LocalDateTime obtenerFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public LocalDateTime obtenerUltimaModificacion() {
        return ultimaModificacion;
    }

    @Override
    public String obtenerUsuarioModificacion() {
        return usuarioModificacion;
    }

    @Override
    public void registrarModificacion(String usuario) {
        this.usuarioModificacion = usuario;
        this.ultimaModificacion = LocalDateTime.now();
    }
}
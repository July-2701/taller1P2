package modelo.cuentas;

import modelo.abstractas.Cuenta;
import modelo.interfaces.*;
import modelo.excepciones.*;
import java.time.*;

public class CuentaCredito extends Cuenta implements Transaccionable, Consultable {

    private double deudaActual;

    public double calcularInteres() { return deudaActual * 0.1 / 12; }
    public double getLimiteRetiro() { return 5000; }
    public String getTipoCuenta() { return "CREDITO"; }

    public void depositar(double m) throws CuentaBloqueadaException {
        verificarBloqueada();
        deudaActual -= m;
    }

    public void retirar(double m) throws CuentaBloqueadaException {
        verificarBloqueada();
        deudaActual += m;
    }

    public double calcularComision(double m) { return m * 0.02; }
    public double consultarSaldo() { return -deudaActual; }

    public String obtenerResumen() { return "Cuenta Crédito"; }
    public boolean estaActivo() { return true; }
    public String obtenerTipo() { return getTipoCuenta(); }

    public LocalDateTime obtenerFechaCreacion() { return LocalDateTime.now(); }
    public LocalDateTime obtenerUltimaModificacion() { return LocalDateTime.now(); }
    public String obtenerUsuarioModificacion() { return "user"; }
    public void registrarModificacion(String u) {}
}
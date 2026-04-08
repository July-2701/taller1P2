package modelo.cuentas;

import modelo.abstractas.Cuenta;
import modelo.interfaces.*;
import modelo.excepciones.*;
import java.time.*;

public class CuentaAhorros extends Cuenta implements Transaccionable, Consultable {

    public double calcularInteres() { return saldo * 0.05 / 12; }
    public double getLimiteRetiro() { return 1000; }
    public String getTipoCuenta() { return "AHORROS"; }

    public void depositar(double m) throws CuentaBloqueadaException {
        verificarBloqueada();
        saldo += m;
    }

    public void retirar(double m) throws CuentaBloqueadaException, SaldoInsuficienteException {
        verificarBloqueada();
        if (m > saldo) throw new SaldoInsuficienteException("Error", saldo, m);
        saldo -= m;
    }

    public double calcularComision(double m) { return m * 0.01; }
    public double consultarSaldo() { return saldo; }

    public String obtenerResumen() { return "Cuenta"; }
    public boolean estaActivo() { return true; }
    public String obtenerTipo() { return getTipoCuenta(); }

    public LocalDateTime obtenerFechaCreacion() { return LocalDateTime.now(); }
    public LocalDateTime obtenerUltimaModificacion() { return LocalDateTime.now(); }
    public String obtenerUsuarioModificacion() { return "user"; }
    public void registrarModificacion(String u) {}
}
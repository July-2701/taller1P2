package modelo.cuentas;

import modelo.abstractas.Cuenta;
import modelo.interfaces.*;
import modelo.excepciones.*;
import java.time.*;

public class CuentaCorriente extends Cuenta implements Transaccionable, Consultable {

    private double comisionMantenimiento = 10;

    public double calcularInteres() { return -comisionMantenimiento; }
    public double getLimiteRetiro() { return 2000; }
    public String getTipoCuenta() { return "CORRIENTE"; }

    public void depositar(double m) throws CuentaBloqueadaException {
        verificarBloqueada();
        saldo += m;
    }

    public void retirar(double m) throws CuentaBloqueadaException, SaldoInsuficienteException {
        verificarBloqueada();
        if (m > saldo) throw new SaldoInsuficienteException("Sin saldo", saldo, m);
        saldo -= m;
    }

    public double calcularComision(double m) { return 5; }
    public double consultarSaldo() { return saldo; }

    public String obtenerResumen() { return "Cuenta Corriente"; }
    public boolean estaActivo() { return true; }
    public String obtenerTipo() { return getTipoCuenta(); }

    public LocalDateTime obtenerFechaCreacion() { return LocalDateTime.now(); }
    public LocalDateTime obtenerUltimaModificacion() { return LocalDateTime.now(); }
    public String obtenerUsuarioModificacion() { return "user"; }
    public void registrarModificacion(String u) {}
}
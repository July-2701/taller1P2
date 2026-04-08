package modelo.abstractas;

import modelo.interfaces.Auditable;
import modelo.excepciones.CuentaBloqueadaException;

public abstract class Cuenta implements Auditable {

    protected double saldo;
    private boolean bloqueada;

    public abstract double calcularInteres();
    public abstract double getLimiteRetiro();
    public abstract String getTipoCuenta();

    public void verificarBloqueada() throws CuentaBloqueadaException {
        if (bloqueada) throw new CuentaBloqueadaException("Cuenta bloqueada");
    }
}
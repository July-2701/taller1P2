package modelo.interfaces;

import modelo.excepciones.*;

public interface Transaccionable {
    void depositar(double monto) throws CuentaBloqueadaException;
    void retirar(double monto) throws CuentaBloqueadaException, SaldoInsuficienteException;
    double calcularComision(double monto);
    double consultarSaldo();
}
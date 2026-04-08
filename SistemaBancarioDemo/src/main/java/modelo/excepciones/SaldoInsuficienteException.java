package modelo.excepciones;

public class SaldoInsuficienteException extends SistemaBancarioException {
    private double saldoActual, montoSolicitado;

    public SaldoInsuficienteException(String msg, double saldo, double monto) {
        super(msg, "SALDO");
        this.saldoActual = saldo;
        this.montoSolicitado = monto;
    }
}
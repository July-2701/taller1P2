package modelo.excepciones;

public class CuentaBloqueadaException extends SistemaBancarioException {
    public CuentaBloqueadaException(String msg) {
        super(msg, "BLOQ");
    }
}
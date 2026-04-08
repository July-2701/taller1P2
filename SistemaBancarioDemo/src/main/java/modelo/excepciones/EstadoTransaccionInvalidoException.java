package modelo.excepciones;

public class EstadoTransaccionInvalidoException extends BancoRuntimeException {
    public EstadoTransaccionInvalidoException(String msg) {
        super(msg);
    }
}
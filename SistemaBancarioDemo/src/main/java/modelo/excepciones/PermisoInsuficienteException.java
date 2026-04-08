package modelo.excepciones;

public class PermisoInsuficienteException extends BancoRuntimeException {
    public PermisoInsuficienteException(String msg) {
        super(msg);
    }
}
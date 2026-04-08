package modelo.excepciones;

public class DatoInvalidoException extends BancoRuntimeException {
    public DatoInvalidoException(String campo, Object valor) {
        super("Dato inválido: " + campo + " -> " + valor);
    }
}
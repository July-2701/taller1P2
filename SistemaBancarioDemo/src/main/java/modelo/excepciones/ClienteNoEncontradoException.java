package modelo.excepciones;

public class ClienteNoEncontradoException extends SistemaBancarioException {
    private String idCliente;

    public ClienteNoEncontradoException(String msg, String id) {
        super(msg, "CLIENTE");
        this.idCliente = id;
    }
}
package modelo.excepciones;

import java.time.LocalDateTime;

public class SistemaBancarioException extends Exception {
    private String codigoError;
    private LocalDateTime timestamp;

    public SistemaBancarioException(String msg, String codigo) {
        super(msg);
        this.codigoError = codigo;
        this.timestamp = LocalDateTime.now();
    }
}

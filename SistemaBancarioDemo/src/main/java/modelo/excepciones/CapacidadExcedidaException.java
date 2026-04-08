package modelo.excepciones;

public class CapacidadExcedidaException extends SistemaBancarioException {
    private int capacidadMaxima;

    public CapacidadExcedidaException(String msg, int max) {
        super(msg, "CAP");
        this.capacidadMaxima = max;
    }
}
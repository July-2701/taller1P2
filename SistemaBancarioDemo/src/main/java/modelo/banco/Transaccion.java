package modelo.banco;

import modelo.abstractas.Cuenta;
import modelo.enums.EstadoTransaccion;
import modelo.excepciones.EstadoTransaccionInvalidoException;

import java.time.LocalDateTime;

public class Transaccion {

    private String id;
    private Cuenta origen;
    private Cuenta destino;
    private double monto;
    private EstadoTransaccion estado;
    private LocalDateTime fecha;

    public Transaccion(String id, Cuenta o, Cuenta d, double monto) {
        this.id = id;
        this.origen = o;
        this.destino = d;
        this.monto = monto;
        this.estado = EstadoTransaccion.PENDIENTE;
        this.fecha = LocalDateTime.now();
    }

    public void cambiarEstado(EstadoTransaccion nuevo) {

        switch (estado) {
            case PENDIENTE:
                if (nuevo != EstadoTransaccion.PROCESANDO && nuevo != EstadoTransaccion.RECHAZADA)
                    throw new EstadoTransaccionInvalidoException("Transición inválida");
                break;

            case PROCESANDO:
                if (nuevo != EstadoTransaccion.COMPLETADA && nuevo != EstadoTransaccion.RECHAZADA)
                    throw new EstadoTransaccionInvalidoException("Transición inválida");
                break;

            case COMPLETADA:
                if (nuevo != EstadoTransaccion.REVERTIDA)
                    throw new EstadoTransaccionInvalidoException("Transición inválida");
                break;

            default:
                throw new EstadoTransaccionInvalidoException("Estado final");
        }

        estado = nuevo;
    }

    public String generarComprobante() {
        return "Transacción " + id + " | Monto: " + monto + " | Estado: " + estado;
    }
}
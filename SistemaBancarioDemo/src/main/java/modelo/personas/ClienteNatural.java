package modelo.personas;

import modelo.interfaces.*;
import java.time.*;

public class ClienteNatural extends Cliente implements Consultable, Notificable, Auditable {

    public ClienteNatural(String id, String n, String a, LocalDate f, String e) {
        super(id,n,a,f,e);
    }

    public int calcularEdad() { return 0; }
    public String obtenerTipo() { return "Natural"; }
    public String obtenerDocumentoIdentidad() { return "CC"; }

    public String obtenerResumen() { return getNombreCompleto(); }
    public boolean estaActivo() { return true; }

    public void notificar(String m) { System.out.println(m); }
    public String obtenerContacto() { return "email"; }
    public boolean aceptaNotificaciones() { return true; }

    public LocalDateTime obtenerFechaCreacion() { return LocalDateTime.now(); }
    public LocalDateTime obtenerUltimaModificacion() { return LocalDateTime.now(); }
    public String obtenerUsuarioModificacion() { return "user"; }
    public void registrarModificacion(String u) {}
}
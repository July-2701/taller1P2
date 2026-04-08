package modelo.personas;

import modelo.interfaces.*;
import java.time.*;

public class ClienteEmpresarial extends Cliente implements Consultable, Notificable, Auditable {

    private String nit;
    private String razonSocial;

    public ClienteEmpresarial(String id, String n, String a, LocalDate f, String e,
                              String nit, String razon) {
        super(id,n,a,f,e);
        this.nit = nit;
        this.razonSocial = razon;
    }

    public int calcularEdad() { return 0; }
    public String obtenerTipo() { return "Empresarial"; }
    public String obtenerDocumentoIdentidad() { return nit; }

    public String obtenerResumen() { return razonSocial; }
    public boolean estaActivo() { return true; }

    public void notificar(String m) { System.out.println(m); }
    public String obtenerContacto() { return "empresa@email.com"; }
    public boolean aceptaNotificaciones() { return true; }

    public LocalDateTime obtenerFechaCreacion() { return LocalDateTime.now(); }
    public LocalDateTime obtenerUltimaModificacion() { return LocalDateTime.now(); }
    public String obtenerUsuarioModificacion() { return "admin"; }
    public void registrarModificacion(String u) {}
}
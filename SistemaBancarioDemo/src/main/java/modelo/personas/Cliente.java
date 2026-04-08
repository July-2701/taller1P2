package modelo.personas;

import modelo.abstractas.Persona;
import java.time.LocalDate;

public abstract class Cliente extends Persona {
    public Cliente(String id, String n, String a, LocalDate f, String e) {
        super(id,n,a,f,e);
    }

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

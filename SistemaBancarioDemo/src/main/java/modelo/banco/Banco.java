package modelo.banco;

import modelo.abstractas.Cuenta;
import modelo.abstractas.Empleado;
import modelo.personas.*;
import modelo.empleados.*;
import modelo.cuentas.*;
import modelo.excepciones.*;

public class Banco {

    private String nombre;
    private Empleado[] empleados;
    private Cliente[] clientes;
    private Cuenta[] cuentas;

    private int contadorEmpleados;
    private int contadorClientes;
    private int contadorCuentas;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.empleados = new Empleado[50];
        this.clientes = new Cliente[200];
        this.cuentas = new Cuenta[500];
        this.contadorEmpleados = 0;
        this.contadorClientes = 0;
        this.contadorCuentas = 0;
    }

    public void registrarCliente(Cliente c) throws CapacidadExcedidaException {
        if (contadorClientes >= clientes.length) {
            throw new CapacidadExcedidaException("Capacidad máxima de clientes alcanzada", clientes.length);
        }
        clientes[contadorClientes++] = c;
    }

    public void registrarEmpleado(Empleado e) throws CapacidadExcedidaException {
        if (contadorEmpleados >= empleados.length) {
            throw new CapacidadExcedidaException("Capacidad máxima de empleados alcanzada", empleados.length);
        }
        empleados[contadorEmpleados++] = e;
    }

    public Cliente buscarCliente(String id) throws ClienteNoEncontradoException {
        for (int i = 0; i < contadorClientes; i++) {
            if (clientes[i].getId().equals(id)) {
                return clientes[i];
            }
        }
        throw new ClienteNoEncontradoException("Cliente no encontrado", id);
    }

    public void abrirCuenta(String idCliente, Cuenta c)
            throws ClienteNoEncontradoException, CapacidadExcedidaException {

        if (contadorCuentas >= cuentas.length) {
            throw new CapacidadExcedidaException("Capacidad máxima de cuentas alcanzada", cuentas.length);
        }

        Cliente cliente = buscarCliente(idCliente);
        cuentas[contadorCuentas++] = c;
    }

    public double calcularNominaTotal() {
        double total = 0;
        for (int i = 0; i < contadorEmpleados; i++) {
            total += empleados[i].calcularSalario();
        }
        return total;
    }

    public void calcularInteresesMensuales() {
        for (int i = 0; i < contadorCuentas; i++) {
            double interes = cuentas[i].calcularInteres();
            System.out.println("Interés generado: " + interes);
        }
    }
}
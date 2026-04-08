package Principal;

import modelo.banco.*;
import modelo.cuentas.*;
import modelo.personas.*;
import modelo.empleados.*;
import modelo.interfaces.*;
import modelo.enums.*;
import modelo.excepciones.*;

import java.time.LocalDate;
import java.util.Scanner;
import modelo.abstractas.Cuenta;
import modelo.abstractas.Empleado;

public class SistemaBancarioDemo {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int op;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Ejecutar escenarios");
            System.out.println("2. Crear cliente");
            System.out.println("3. Crear empleado");
            System.out.println("0. Salir");

            op = sc.nextInt();

            switch (op) {
                case 1 -> ejecutarEscenarios();
                case 2 -> crearCliente();
                case 3 -> crearEmpleado();
            }

        } while (op != 0);
    }

    static void ejecutarEscenarios() {

        System.out.println("\n===== ESCENARIOS =====");

        try {

            Banco banco = new Banco("MiBanco");

            Cliente c1 = new ClienteNatural("1","Juan","Perez",LocalDate.of(2000,1,1),"a@a.com");
            Cliente c2 = new ClienteNatural("2","Ana","Lopez",LocalDate.of(1999,1,1),"b@b.com");
            Cliente c3 = new ClienteEmpresarial("3","Empresa","SAS",LocalDate.of(2000,1,1),"c@c.com","123","EmpresaX");

            banco.registrarCliente(c1);
            banco.registrarCliente(c2);
            banco.registrarCliente(c3);

            System.out.println("Clientes registrados");

            Cuenta ahorro = new CuentaAhorros();
            Cuenta corriente = new CuentaCorriente();
            Cuenta credito = new CuentaCredito();

            System.out.println("Cuentas creadas");

            try {
                ((Transaccionable) ahorro).depositar(100);
                ahorro.verificarBloqueada();
                System.out.println("Deposito exitoso");
            } catch (CuentaBloqueadaException e) {
                System.out.println("Cuenta bloqueada capturada");
            }

            try {
                ((Transaccionable) corriente).retirar(9999);
            } catch (SaldoInsuficienteException e) {
                System.out.println("Saldo insuficiente capturado");
            } catch (CuentaBloqueadaException e) {
                System.out.println(e.getMessage());
            }

            try {
                ((Transaccionable) ahorro).depositar(200);
                ((Transaccionable) ahorro).retirar(100);
                ((Transaccionable) corriente).depositar(100);
                System.out.println("Transferencia realizada");
            } catch (CuentaBloqueadaException | SaldoInsuficienteException e) {
                System.out.println(e.getMessage());
            }

            Empleado[] empleados = {
                new Cajero("1","A","A",LocalDate.now(),"a","1",LocalDate.now(),1000),
                new AsesorFinanciero("2","B","B",LocalDate.now(),"b","2",LocalDate.now(),1200,15000),
                new GerenteSucursal("3","C","C",LocalDate.now(),"c","3",LocalDate.now(),2000,"Central",50000)
            };

            for (Empleado e : empleados) {
                System.out.println(e.obtenerTipo() + ": " + e.calcularSalario());
            }

            Cuenta[] cuentas = {ahorro, corriente, credito};

            for (Cuenta cu : cuentas) {
                System.out.println(cu.getTipoCuenta() + ": " + cu.calcularInteres());
            }

            try {
                Transaccion t = new Transaccion("T1", ahorro, corriente, 100);
                t.cambiarEstado(EstadoTransaccion.COMPLETADA);
            } catch (EstadoTransaccionInvalidoException e) {
                System.out.println("Estado inválido capturado");
            }

            try {
                throw new PermisoInsuficienteException("Acción no permitida");
            } catch (PermisoInsuficienteException e) {
                System.out.println("Permiso insuficiente capturado");
            }

            if (c1 instanceof Notificable n && n.aceptaNotificaciones()) {
                n.notificar("Notificación enviada");
            }

            if (ahorro instanceof Auditable a) {
                a.registrarModificacion("admin");
                System.out.println(a.obtenerUltimaModificacion());
                System.out.println(a.obtenerUsuarioModificacion());
            }
            
            double total = 0;
            for (Empleado e : empleados) {
                total += e.calcularSalario();
            }

            System.out.println("Nomina total: " + total);

        } catch (CapacidadExcedidaException e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }

    static void crearCliente() {

        sc.nextLine();

        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        Cliente c = new ClienteNatural(id, nombre, apellido, LocalDate.now(), email);

        System.out.println("Cliente creado: " + c.getNombreCompleto());
    }

    static void crearEmpleado() {

        sc.nextLine();

        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Legajo: ");
        String legajo = sc.nextLine();

        System.out.print("Salario: ");
        double salario = sc.nextDouble();

        Empleado e = new Cajero(id, nombre, apellido, LocalDate.now(), email, legajo, LocalDate.now(), salario);

        System.out.println("Empleado creado: " + e.obtenerTipo());
    }
}
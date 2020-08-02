import java.util.Calendar;

/**
 * BootCamp SENA Agosto 2020
 * 
 * @author Danniela Riaño Huertas
 * @author Veronica Ortiz Rocha
 * @author Carlos Moreno Cifuentes
 */
public class Cliente {

    private int idCliente;
    private static int contadorCliente = 0;

    private String nombre;
    private String cedula;
    private CuentaAhorros cuentaAhorros;
    private CuentaCorriente cuentaCorriente;
    private Cdt cdt;
    private boolean cdtActivo;

    public Cliente(String nombre, String cedula) {
        this.idCliente = ++contadorCliente;
        this.nombre = nombre;
        this.cedula = cedula;
        this.cuentaAhorros = new CuentaAhorros();
        this.cuentaCorriente = new CuentaCorriente();
        this.cdtActivo = false;

        System.out.println("===============================================================\n"
                        + "|             Cliente creado satisfactoriamente\n"
                        + "===============================================================\n|"
        + "\n| ID Cliente: " + this.idCliente
        + "\n|"
        + "\n| Nombre: " + this.nombre
        + "\n| Cédula: " + this.cedula
        + "\n|\n| Cuenta Ahorros # " + this.cuentaAhorros.getIdCuenta()
        + "\n| Cuenta Corriente # " + this.cuentaCorriente.getIdCuenta());
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return this.cedula;
    }

    public double consignarCtaAhorros(double monto) {
        return this.cuentaAhorros.consignarMonto(monto);
    }

    public double consignarCtaCorriente(double monto) {
        return this.cuentaCorriente.consignarMonto(monto);
    }

    public double saldoCtaAhorros() {
        return this.cuentaAhorros.consultarSaldo();
    }

    public double saldoCtaCorriente() {
        return this.cuentaCorriente.consultarSaldo();
    }

    public double retirarCtaAhorros(double monto) {
        return this.cuentaAhorros.retirarMonto(monto);
    }

    public double retirarCtaCorriente(double monto) {
        return this.cuentaCorriente.retirarMonto(monto);
    }

    public double capitalTotal() {
        return this.cuentaAhorros.consultarSaldo() + this.cuentaCorriente.consultarSaldo();
    }

    public void abrirCdt(double monto, double intereses, Calendar fechaApertura, int mesesPactados) {
        this.cdtActivo = true;
        this.cdt = new Cdt(monto, intereses, fechaApertura, mesesPactados);
    }

    public double cerrarCdt() {
        if (!this.cdtActivo) {
            System.out.println("|| El cliente no tiene CDTs activos");
            return 0;
        } else {
            this.cdtActivo = false;
            return this.cuentaCorriente.consignarMonto(this.cdt.cerrarCdt());
        }
    }

    @Override
    public String toString() {
        return "ID Cliente: " + this.idCliente
            + "\nNombre: " + this.nombre
            + "\nCédula: " + this.cedula
            + "\nCDT Activo: " + this.cdtActivo;
    }
}

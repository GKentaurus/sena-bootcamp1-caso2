/**
 * BootCamp SENA Agosto 2020
 * 
 * @author Danniela Riaño Huertas
 * @author Veronica Ortiz Rocha
 * @author Carlos Moreno Cifuentes
 */

public class CuentaAhorros extends CuentaBancaria {
    double saldo;

    public CuentaAhorros() {
        super();
        this.saldo = 0;
    }

    public double consignarMonto(double monto) {
        return this.saldo = this.saldo + monto;
    }

    public double retirarMonto(double monto) {
        if (monto > this.saldo) {
            System.out.println("Saldo insuficiente");
            return this.saldo;
        } else {
            return this.saldo = this.saldo - monto;
        }
    }

    public double consultarSaldo() {
        return this.saldo;
    }
}
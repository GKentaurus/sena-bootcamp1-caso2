/**
 * BootCamp SENA Agosto 2020
 * 
 * @author Danniela Riaño Huertas
 * @author Veronica Ortiz Rocha
 * @author Carlos Moreno Cifuentes
 */
public class CuentaBancaria {
    private int idCuenta;
    private static int contadorCuentas = 0;

    public CuentaBancaria () {
        this.idCuenta = ++contadorCuentas;
    }

    public int getIdCuenta() {
        return this.idCuenta;
    }
}

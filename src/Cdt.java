import java.util.Calendar;

/**
 * BootCamp SENA Agosto 2020
 * 
 * @author Danniela Riaño Huertas
 * @author Veronica Ortiz Rocha
 * @author Carlos Moreno Cifuentes
 */
public class Cdt {
    
    private int idCdt;
    private static int contadorCdt = 0;

    private double monto;
    private double interes;
    private Calendar fechaApertura;
    private int mesesPactados;

    /**
     * 
     * @param monto
     * @param interes
     * @param fechaApertura
     * @param mesesPactados
     */
    public Cdt(double monto, double interes, Calendar fechaApertura, int mesesPactados){
        this.idCdt = ++contadorCdt;
        this.monto = monto;
        this.interes = interes;
        this.fechaApertura = fechaApertura;
        this.mesesPactados = mesesPactados;
    }

    public int getIdCdt() {
        return this.idCdt;
    }

    public static int getContadorCdt() {
        return contadorCdt;
    }

    public double getMonto() {
        return this.monto;
    }

    public double getInteres() {
        return this.interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public Calendar getFechaApertura() {
        return this.fechaApertura;
    }

    public void setFechaApertura(Calendar fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public int getMesesPactados() {
        return this.mesesPactados;
    }

    public void setMesesPactados(int mesesPactados) {
        this.mesesPactados = mesesPactados;
    }

    public double cerrarCdt () {
        double rentabilidadMensual = this.monto * (this.interes/100);
        return this.monto + (rentabilidadMensual * this.mesesPactados);
    }

}

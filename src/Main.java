import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * BootCamp SENA Agosto 2020
 * 
 * @author Danniela Riaño Huertas
 * @author Veronica Ortiz Rocha
 * @author Carlos Moreno Cifuentes
 */
public class Main {
    public static void main(final String[] args) throws IOException {
        final Scanner input = new Scanner(System.in);
        boolean repetir, continuar = true;
        int idCliente, mesesPactados, intentos;
		final int limiteIntentos = 3;
        double monto, intereses;

        final ArrayList<Cliente> listaClientes = new ArrayList<>();
        do {
            cls();
            System.out.print( "===============================================================\n"
                            + "|                       Menú Principal\n"
                            + "===============================================================\n"
                            + "| 1. | Registrar cliente\n"
                            + "| 2. | Consignar cuenta corriente\n"
                            + "| 3. | Consignar cuenta ahorros\n"
                            + "| 4. | Invertir en CDT\n"
                            + "| 5. | Calcular el saldo total de las cuentas\n"
                            + "| 6. | Retirar cuenta corriente\n"
                            + "| 7. | Retirar cuenta ahorros\n"
                            + "| 8. | Consultar saldo cuenta ahorros\n"
                            + "| 9. | Consultar saldo cuenta corriente\n"
                            + "| 10.| Cerrar CDT\n"
                            + "| 11.| Simulación saldo cuenta ahorros con intereses\n"
                            + "| 12.| Salir del programa\n"
                            + "===============================================================\n"
                            + "> Opción:\t");
            
            final int menu = input.nextInt();
            switch (menu) {
                case 1:
                    cls();
                    System.out.println("===============================================================\n"
                                    + "|                   Registrar nuevo cliente\n"
                                    + "===============================================================");
                    input.nextLine();
                    System.out.print("| Ingrese el nombre del Cliente: ");
                    final String nombre = input.nextLine();
                    System.out.print("| Ingrese el documento de identidad de " + nombre +": ");
                    final String cedula = input.nextLine();
                    listaClientes.add(new Cliente(nombre, cedula));
                    pausa();
                    break;
                case 2:
                    cls();
                    System.out.println("===============================================================\n"
                                    + "|              Consignación a cuenta corriente\n"
                                    + "===============================================================");
                    input.nextLine();
                    intentos = 0;
                    repetir = true;
                    do {
                        intentos++;
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir && intentos < limiteIntentos);
                    if (intentos < limiteIntentos) {
                        System.out.print("| Indique el monto a ingresar: ");
                        monto = input.nextDouble();
                        System.out.println("| El nuevo saldo: " + listaClientes.get(idCliente).consignarCtaCorriente(monto));
                    } else {
                        System.out.println("| Excedió el número de intentos para la transacción");
                    }
                    pausa();
                    break;
                case 3:
                    cls();
                    System.out.println("===============================================================\n"
                                    + "|                Consignación a cuenta ahorros\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    intentos = 0;
                    do {
                        intentos++;
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir && intentos < limiteIntentos);
                    if (intentos < limiteIntentos) {
                        System.out.print("| Indique el monto a ingresar: ");
                        monto = input.nextDouble();
                        System.out.println("| El nuevo saldo: " + listaClientes.get(idCliente).consignarCtaAhorros(monto));
                    } else {
                        System.out.println("| Excedió el número de intentos para la transacción");
                    }
                    pausa();
                    break;
                case 4:
                    cls();
                    System.out.println("===============================================================\n"
                                    + "|                          Abrir CDT\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    intentos = 0;
                    do {
                        intentos++;
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir && intentos < limiteIntentos);

                    if (intentos < limiteIntentos) {
                        System.out.print("| Indique el monto a invertir: ");
                        monto = input.nextDouble();
                        System.out.print("| Indique los intereses pactados: ");
                        intereses = input.nextDouble();
                        System.out.print("| Indique los meses pactados: ");
                        mesesPactados = input.nextInt();
                        final Calendar fechaApertura = Calendar.getInstance();
                        listaClientes.get(idCliente).abrirCdt(monto, intereses, fechaApertura, mesesPactados);
                        System.out.println("| CDT Creado");
                    } else {
                        System.out.println("| Excedió el número de intentos para la transacción");
                    }
                    pausa();
                    break;
                case 5:
                    cls();
                    System.out.println("===============================================================\n"
                                    + "|                   Consultar Capital Total\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    intentos = 0;
                    do {
                        intentos++;
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir && intentos < limiteIntentos);

                    if (intentos < limiteIntentos) {
                        System.out.println("| El saldo total: " + listaClientes.get(idCliente).capitalTotal());
                    } else {
                        System.out.println("| Excedió el número de intentos para la transacción");
                    }
                    pausa();
                    break;
                case 6:
                    cls();
                    System.out.println("===============================================================\n"
                                    + "|                  Retirar cuenta corriente\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    intentos = 0;
                    do {
                        intentos++;
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir && intentos < limiteIntentos);

                    if (intentos < limiteIntentos) {
                        System.out.println("| Ingrese el monto a retirar:");
                        monto = input.nextDouble();
                        System.out.println("| Saldo: " + listaClientes.get(idCliente).retirarCtaCorriente(monto));
                    } else {
                        System.out.println("| Excedió el número de intentos para la transacción");
                    }
                    pausa();
                    break;
                case 7:
                    cls();
                    System.out.println("===============================================================\n"
                                    + "|                   Retirar cuenta ahorros\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    intentos = 0;
                    do {
                        intentos++;
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir && intentos < limiteIntentos);

                    if (intentos < limiteIntentos) {   
                        System.out.print("| Ingrese el monto a retirar:");
                        monto = input.nextDouble();
                        System.out.println("| Saldo: " + listaClientes.get(idCliente).retirarCtaAhorros(monto));
                    }  else {
                        System.out.println("| Excedió el número de intentos para la transacción");
                    }
                    pausa();
                    break;
                case 8:
                    cls();
                    System.out.println("===============================================================\n"
                                    + "|                  Consultar cuenta ahorros\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    intentos = 0;
                    do {
                        intentos = 0;
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir && intentos < limiteIntentos);

                    if (intentos < limiteIntentos) {
                        System.out.println("| El saldo actual - cuenta de ahorros: " + listaClientes.get(idCliente).saldoCtaAhorros());
                    }  else {
                        System.out.println("| Excedió el número de intentos para la transacción");
                    }
                    pausa();
                    break;
                case 9:
                    cls();
                    System.out.println("===============================================================\n"
                                    + "|                 Consultar cuenta corriente\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    intentos = 0;
                    do {
                        intentos++;
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir && intentos < limiteIntentos);

                    if (intentos < limiteIntentos){
                        System.out.println("| El saldo actual - cuenta de corriente: " + listaClientes.get(idCliente).saldoCtaCorriente());
                    }   else {
                        System.out.println("| Excedió el número de intentos para la transacción");
                    }
                    pausa();
                    break;
                case 10:
                    cls();
                    System.out.println("===============================================================\n"
                                    + "|                         Cerrar CDT\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    intentos = 0;
                    do {
                        intentos++;
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir && intentos < limiteIntentos);

                    if (intentos < limiteIntentos){
                        System.out.println("| Monto ingresado a la cuenta corriente: " + listaClientes.get(idCliente).cerrarCdt());
                    }  else {
                        System.out.println("| Excedió el número de intentos para la transacción");
                    }
                    pausa();
                    break;
                case 11:
                    cls();
                    System.out.println("===============================================================\n"
                                    + "|        Simulación saldo cuenta ahorros con intereses\n"
                                    + "===============================================================");
                    System.out.print("| Indique por favor el monto a invertir: ");
                    monto = input.nextDouble();
                    System.out.print("| Indique los intereses pactados: ");
                    intereses = input.nextDouble();
                    System.out.print("| Indique los meses pactados: ");
                    mesesPactados = input.nextInt();

                    final double simulacionCDT = ((double)mesesPactados * (monto * (intereses)/100)) + monto;
                    System.out.println("| El valor total al momento de culminar el CDT es: " + simulacionCDT);
                    pausa();
                    break;
                case 12:
                    cls();
                    System.out.println("\n\n" 
                    + "\nSistema desarrollado por <CODEBRANCH>\n"
                    + "\n\tFicha 2025316/2025342"
                    + "\n\t->  Veronica Ortiz <-"
                    + "\n\t->  Danniela Riaño <-"
                    + "\n\t->  Carlos Moreno  <-"
                    +"\n\nGracias por usar este servicio");
                    continuar = false;
                    pausa();
                    cls();
                    break;
                default:
                    cls();
                    System.out.println("| Ha seleccionado una opción inválida");
                    pausa();
                    break;
            }
        } while (continuar);
        input.close();
    }

    public static boolean comprobarCliente(final ArrayList<Cliente> listaClientes, final int idCliente) {
        boolean repetir = false;
        if (idCliente >= 0 && idCliente < listaClientes.size() && listaClientes.size() >= 1) {
            repetir = false;
        } else {
            System.out.println("|\n| -> El ID que ingresó no es válido."
                                +"\n| -> Intente nuevamente.\n|");
            repetir = true;
        }

        return repetir;
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pausa() {
        System.out.println("\nPresione una tecla para continuar...");
        new Scanner(System.in).nextLine();
    }
}

import java.util.Scanner;
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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean repetir, continuar = true;
        int idCliente, mesesPactados;
        double monto, intereses;

        ArrayList<Cliente> listaClientes = new ArrayList<>();
        
        do {
            System.out.println("===============================================================\n"
                                + "|                Escoja una opción de menú                    |\n"
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
                                + "===============================================================\n");
            
            int menu = input.nextInt();
            switch (menu) {
                case 1:
                System.out.println("===============================================================\n"
                                + "|                   Registrar nuevo cliente                   |\n"
                                + "===============================================================");
                    input.nextLine();
                    System.out.print("| Ingrese el nombre del Cliente: ");
                    String nombre = input.nextLine();
                    System.out.print("| Ingrese el documento de identidad de " + nombre +": ");
                    String cedula = input.nextLine();
                    listaClientes.add(new Cliente(nombre, cedula));
                    break;
                case 2:
                    System.out.println("===============================================================\n"
                                    + "|              Consignación a cuenta corriente                |\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    do {
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir);

                    System.out.print("| Indique el monto a ingresar: ");
                    monto = input.nextDouble();
                    System.out.println("| El nuevo saldo: " + listaClientes.get(idCliente).consignarCtaCorriente(monto));
                    break;
                case 3:
                    System.out.println("===============================================================\n"
                                    + "|                Consignación a cuenta ahorros                |\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    do {
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir);

                    System.out.print("| Indique el monto a ingresar: ");
                    monto = input.nextDouble();
                    System.out.println("| El nuevo saldo: " + listaClientes.get(idCliente).consignarCtaAhorros(monto));
                    break;
                case 4:
                    System.out.println("===============================================================\n"
                                + "|                          Abrir CDT                          |\n"
                                + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    do {
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir);

                    System.out.print("| Indique el monto a invertir: ");
                    monto = input.nextDouble();
                    System.out.print("| Indique los intereses pactados: ");
                    intereses = input.nextDouble();
                    System.out.print("| Indique los meses pactados: ");
                    mesesPactados = input.nextInt();
                    Calendar fechaApertura = Calendar.getInstance();
                    listaClientes.get(idCliente).abrirCdt(monto, intereses, fechaApertura, mesesPactados);
                    System.out.println("| CDT Creado");
                    break;
                case 5:
                    System.out.println("===============================================================\n"
                                    + "|                   Consultar Capital Total                   |\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    do {
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir);

                    System.out.println("| El saldo total: " + listaClientes.get(idCliente).capitalTotal());
                    break;
                case 6:
                    System.out.println("===============================================================\n"
                                    + "|                  Retirar cuenta corriente                   |\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    do {
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir);

                    System.out.println("| Ingrese el monto a retirar:");
                    monto = input.nextDouble();
                    System.out.println("| El nuevo saldo: " + listaClientes.get(idCliente).retirarCtaCorriente(monto));
                    break;
                case 7:
                    System.out.println("===============================================================\n"
                                    + "|                   Retirar cuenta ahorros                    |\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    do {
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir);

                    System.out.print("| Ingrese el monto a retirar:");
                    monto = input.nextDouble();
                    System.out.println("| El nuevo saldo: " + listaClientes.get(idCliente).retirarCtaAhorros(monto));
                    break;
                case 8:
                    System.out.println("===============================================================\n"
                                    + "|                  Consultar cuenta ahorros                   |\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    do {
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir);

                    System.out.println("| El saldo actual - cuenta de ahorros: " + listaClientes.get(idCliente).saldoCtaAhorros());
                    break;
                case 9:
                    System.out.println("===============================================================\n"
                                    + "|                 Consultar cuenta corriente                  |\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    do {
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir);

                    System.out.println("| El saldo actual - cuenta de corriente: " + listaClientes.get(idCliente).saldoCtaCorriente());
                    break;
                case 10:
                    System.out.println("===============================================================\n"
                                    + "|                         Cerrar CDT                          |\n"
                                    + "===============================================================");
                    input.nextLine();
                    repetir = true;
                    do {
                        System.out.print("| Indique el ID del cliente:");
                        idCliente = input.nextInt()-1;
                        repetir = comprobarCliente(listaClientes, idCliente);
                    } while (repetir);

                    System.out.println("| Monto ingresado a la cuenta corriente: " + listaClientes.get(idCliente).cerrarCdt());
                    break;
                case 11:
                    System.out.println("===============================================================\n"
                                    + "|        Simulación saldo cuenta ahorros con intereses        |\n"
                                    + "===============================================================");
                    System.out.print("| Indique por favor el monto a invertir: ");
                    monto = input.nextDouble();
                    System.out.print("| Indique los intereses pactados: ");
                    intereses = input.nextDouble();
                    System.out.print("| Indique los meses pactados: ");
                    mesesPactados = input.nextInt();

                    double simulacionCDT = ((double)mesesPactados * (monto * intereses)) + monto;
                    System.out.println("| El valor total al momento de culminar el CDT es: " + simulacionCDT);
                    break;
                case 12:
                    System.out.println("Gracias por usar este servicio");
                    continuar = false;
                    break;
                case 13:
                    System.out.print("ID Cliente: ");
                    idCliente = input.nextInt();
                    System.out.println(listaClientes.get(idCliente).toString());
                    break;
                default:
                    break;
            }
        } while (continuar);
        input.close();
    }

    public static boolean comprobarCliente(ArrayList<Cliente> listaClientes, int idCliente) {
        boolean repetir = false;
        if (idCliente >= 0 && idCliente <= listaClientes.size()) {
            repetir = false;
        } else {
            System.out.println("|| El ID que ingresó no es válido. ||");
            repetir = true;
        }

        return repetir;
    }
}

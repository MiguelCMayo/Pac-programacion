package pac_programcion;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //CREACION DE ATRIBUTOS
        Scanner scanner = new Scanner(System.in);
        Usuario usuario1 = new Usuario();
        Cuenta cuenta1 = new Cuenta(usuario1);
        String auxDesc;
        double auxImp;
        double saldo;
        Iterator<Gasto> iteratorG;
        Iterator<Ingreso> iteratorI;
        Gasto gasto;
        Ingreso ingreso;
        NumberFormat saldoFormato = NumberFormat.getCurrencyInstance(new Locale("es","ES"));

        //INTRODUCIR EL NOMBRE DEL USUARIO
        System.out.println("Introduce el nombre del usuario");
        scanner=new Scanner(System.in);
        usuario1.setNombre(scanner.nextLine());

        //INTRODUCIR LA EDAD DEL USUARIO
        for (int i = 1; i <= 100; i++) {
            try {
                System.out.println("Introduce la edad del usuario");
                scanner = new Scanner(System.in);
                usuario1.setEdad(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: La edad debe ser un valor numérico");
            }
        }

        //INTRODUCIR EL DNI
        for (int i = 1; i <= 100; i++) {
            System.out.println("Introduce el DNI del usuario");
            scanner = new Scanner(System.in);
            if (!usuario1.setDNI(scanner.nextLine())) {
                System.out.println("DNI introducido incorrecto");
            }else {
                System.out.println("Usuario creado correctamente");
                System.out.println(cuenta1.toString());
                break;
            }
        }

        //INTRODUCIR LAS ACCIONES
        for (int i = 1; i <= 100; i++){
            System.out.println("Realiza una nueva acción:");
            System.out.println("1 Introduce un nuevo gasto\n" + "2 Introduce un nuevo ingreso\n" +
                    "3 Mostrar gastos\n" + "4 Mostrar ingresos\n" + "5 Mostrar saldo\n" + "0 Salir");

            switch (Integer.parseInt(scanner.nextLine())) {

                case 1:

                    System.out.println("Introduce la descripción: ");

                    auxDesc = scanner.nextLine();
                    auxImp = 0;

                    do {
                        try {
                            System.out.println("Introduce la cantidad: ");
                            auxImp = scanner.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Introduce un valor numérico");
                        }
                        scanner.nextLine();
                    } while (auxImp <= 0);

                    saldo = cuenta1.addGastos(auxDesc, auxImp);

                    System.out.println("Saldo restante: " + saldoFormato.format(saldo));
                    break;

                case 2:

                    System.out.println("Introduce la descripción: ");

                    auxDesc = scanner.nextLine();
                    auxImp = 0;

                    do {
                        try {
                            System.out.println("Introduce la cantidad: ");
                            auxImp = scanner.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Introduce un valor numérico");
                        }
                        scanner.nextLine();
                    } while (auxImp <= 0);

                        saldo = cuenta1.addIngresos(auxDesc, auxImp);

                        System.out.println("Saldo restante: " + saldoFormato.format(saldo));

                case 3:

                    iteratorG = cuenta1.getGastos().iterator();
                    while (iteratorG.hasNext()) {
                        System.out.println(iteratorG.next().toString());
                    }
                    break;

                case 4:

                    iteratorI = cuenta1.getIngresos().iterator();
                    while (iteratorI.hasNext()) {
                        System.out.println(iteratorI.next().toString());
                    }
                    break;

                case 5:

                    System.out.println("El saldo actual de la cuenta es:" + saldoFormato.format(cuenta1.getSaldo()));
                    break;

                case 0:

                    System.out.println("Fin del programa.\n" +
                            "Gracias por utilizar la aplicación de M03B en el curso 1s2223");
                    System.exit(0);
                    break;

                default:
                    System.out.println("La accion indicada es incorrecta");
            }
        }
    }
}
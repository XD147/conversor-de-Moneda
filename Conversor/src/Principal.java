import com.sun.source.tree.CaseTree;

import java.util.Scanner;

public class Principal {
    static void main(String[] args) {
        String menu = """
                ************************************************************
                ...::: Bienvenido/a al conversor de monedas :::...
                
                1) Dólar =>>> Peso argentino
                2) Peso argentino =>>> Dólar
                3) Dólar =>>> Real brasileño
                4) Real brasileño =>>> Dólar
                5) Dólar =>>> Peso Colombiano
                6) Peso colombiano =>>> Dólar
                7) Salir
                
                Elija una opsión válida:
                """;

        Scanner lectura = new Scanner(System.in);
        int opsion = 0;
        double cantidad = 0;

        ConsultaApi consultaApi = new ConsultaApi();

        try {

            while (true) {
                System.out.println(menu);
                opsion = lectura.nextInt();

                if (opsion == 7) {
                    System.out.println("Saliendo de la aplicación!");
                    break; // sale del while
                }

                System.out.println("Ingrese el valor que quiere convertir: ");
                cantidad = lectura.nextDouble();

                switch (opsion) {
                    case 1 -> System.out.println(consultaApi.Pair("USD", "ARS", cantidad));
                    case 2 -> System.out.println(consultaApi.Pair("ARS", "USD", cantidad));
                    case 3 -> System.out.println(consultaApi.Pair("USD", "BRL", cantidad));
                    case 4 -> System.out.println(consultaApi.Pair("BRL", "USD", cantidad));
                    case 5 -> System.out.println(consultaApi.Pair("USD", "COP", cantidad));
                    case 6 -> System.out.println(consultaApi.Pair("COP", "USD", cantidad));
                    default -> System.out.println("Opción inválida");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Ingrese una opsión válida");
        }
    }
}

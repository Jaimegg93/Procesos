package procesos.aleatorios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Aleatorios {

    public static void aleatorios(Scanner scanner){
        String entrada;

        System.out.println("Escribe 'fin' para terminar o cualquier otra cosa para continuar.");

        while (true) {
            System.out.print("Entrada: ");
            entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("fin")) {
                System.out.println("Programa terminado.");
                break;
            }

            try {
                // Ruta al ejecutable generado por el programa C
                String cProgramPath = "C:\\Users\\jaime\\Desktop\\Calse\\Procesos\\Tema1\\Aleatorios\\bin\\Release\\Aleatorios.exe";

                // Ejecutar el programa C
                Process process = Runtime.getRuntime().exec(cProgramPath);

                // Leer la salida del programa C
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String output = reader.readLine();

                if (output != null) {
                    int randomNumber = Integer.parseInt(output.trim());
                    System.out.println("Número aleatorio generado por C: " + randomNumber);
                } else {
                    System.out.println("No se recibió ningún número del programa C.");
                }

                // Cerrar el lector
                reader.close();

                // Esperar a que el proceso termine
                process.waitFor();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
    }

